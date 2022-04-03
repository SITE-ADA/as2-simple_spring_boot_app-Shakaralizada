package com.as.assignment.model;

import javax.persistence.*;
import java.util.Set;

@Entity public class Manufacturer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "M_ID") private Integer id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer") private Set<Phone> phones;

    public Manufacturer() { }

    public Manufacturer(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    @Override public String toString() {
        return name;
    }
}
