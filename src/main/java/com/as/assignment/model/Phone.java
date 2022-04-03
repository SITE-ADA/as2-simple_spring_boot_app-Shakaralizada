package com.as.assignment.model;

import javax.persistence.*;

@Entity public class Phone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "P_ID") private Integer id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL) @JoinTable(name = "PHONE_MANUFACTURER", joinColumns = @JoinColumn(name = "P_ID"), inverseJoinColumns = @JoinColumn(name = "M_ID")) private Manufacturer manufacturer;

    public Phone() {
    }

    public Phone(String name) {
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

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override public String toString() {
        return name;
    }
}
