package com.as.assignment.service;

import com.as.assignment.model.Phone;
import com.as.assignment.repo.PhoneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service public class PhoneService {

    @Autowired private PhoneRepo repo;

    public List<Phone> all() {
        return repo.findAll();
    }

    public Phone id(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional public void create(Phone phone) {
        repo.save(phone);
    }

    @Transactional public void update(Phone phone) {
        repo.update(phone.getId(), phone.getName());
    }

    @Transactional public void delete(Integer id) {
        delete_manufacturer(id);
        repo.delete(id(id));
    }

    @Transactional public void delete_manufacturer(Integer id) {
        repo.delete_phone_from_manufacturer(id);
    }
}
