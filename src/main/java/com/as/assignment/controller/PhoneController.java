package com.as.assignment.controller;

import com.as.assignment.model.Phone;
import com.as.assignment.service.PhoneService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller @RequestMapping("/phone") public class PhoneController {

    private final PhoneService service;

    public PhoneController(PhoneService service) {
        this.service = service;
    }


    @GetMapping("/") public String all(Model model) {
        model.addAttribute("phones", service.all());
        return "phone/all";
    }

    @GetMapping("/{id}") public String phone(@PathVariable Integer id, Model model) {
        model.addAttribute("phone", service.id(id));
        return "phone/phone";
    }

    @GetMapping("/create") public String create(Model model) {
        model.addAttribute("phone", new Phone());
        return "phone/create";
    }

    @PostMapping("/created") public String created(Model model, Phone phone) {
        service.create(phone);
        model.addAttribute("phones", service.all());
        return "phone/all";
    }

    @GetMapping("/update/{id}") public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("phone", service.id(id));
        return "phone/update";
    }

    @PostMapping("/updated") public String updated(Model model, Phone phone) {
        service.update(phone);
        model.addAttribute("phones", service.all());
        return "phone/all";
    }

    @GetMapping("/delete/{id}") public String delete(@PathVariable Integer id, Model model) {
        service.delete(id);
        model.addAttribute("phones", service.all());
        return "phone/all";
    }

    @GetMapping("delete_phone_manufacturer/{id}") public String delete_phone_manufacturer(@PathVariable Integer id, Model model) {
        service.delete_manufacturer(id);
        model.addAttribute("phones", service.all());
        return "phone/all";
    }
}
