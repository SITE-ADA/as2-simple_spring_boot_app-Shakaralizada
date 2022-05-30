package com.as.assignment.service;

import com.as.assignment.model.Manufacturer;
import com.as.assignment.repo.ManufacturerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service public class ManufacturerService {

    @Autowired private ManufacturerRepo repo;

    public List<Manufacturer> all() {
        return repo.findAll();
    }

    public Manufacturer id(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional public void create(Manufacturer manufacturer) {
        repo.save(manufacturer);
    }

    @Transactional public void update(Manufacturer manufacturer) {
        repo.update(manufacturer.getId(), manufacturer.getName());
    }

    @Transactional public void delete(Integer id) {
        repo.delete_phones_from_manufacturer(id);
        repo.deleteById(id);
    }

    @Transactional public void delete_phone_from_manufacturer(Integer id_1, Integer id_2) {
        repo.delete_phone_from_manufacturer(id_1, id_2);
    }
}
