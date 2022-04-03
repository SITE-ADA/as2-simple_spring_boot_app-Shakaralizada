package com.as.assignment.controller;

import com.as.assignment.model.Manufacturer;
import com.as.assignment.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller @RequestMapping("/manufacturer") public class ManufacturerController {

    private final ManufacturerService service;

    public ManufacturerController(ManufacturerService service) {
        this.service = service;
    }

    @GetMapping("/") public String all(Model model) {
        model.addAttribute("manufacturers", service.all());
        return "manufacturer/all";
    }

    @GetMapping("/{id}") public String manufacturer(@PathVariable Integer id, Model model) {
        model.addAttribute("manufacturer", service.id(id));
        return "manufacturer/manufacturer";
    }

    @GetMapping("/create") public String create(Model model) {
        model.addAttribute("manufacturer", new Manufacturer());
        return "manufacturer/create";
    }

    @PostMapping("/created") public String created(Model model, Manufacturer manufacturer) {
        service.create(manufacturer);
        model.addAttribute("manufacturer", service.all());
        return "manufacturer/all";
    }

    @GetMapping("/update/{id}") public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("manufacturer", service.id(id));
        return "manufacturer/update";
    }

    @PostMapping("/updated") public String updated(Model model, Manufacturer manufacturer) {
        service.update(manufacturer);
        model.addAttribute("manufacturers", service.all());
        return "manufacturer/all";
    }

    @GetMapping("/delete/{id}") public String delete(@PathVariable Integer id, Model model) {
        service.delete(id);
        model.addAttribute("manufacturers", service.all());
        return "manufacturer/all";
    }

    @GetMapping("delete_manufacturer_phone/{m_id}/{p_id}") public String delete_manufacturer_phone(@PathVariable("m_id") Integer man_id, @PathVariable("p_id") Integer phone_id, Model model) {
        service.delete_phone_from_manufacturer(man_id, phone_id);
        model.addAttribute("manufacturer", service.all());
        return "manufacturer/all";
    }


}
