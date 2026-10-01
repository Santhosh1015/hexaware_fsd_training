package com.helpDeskV2.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;

@Entity
public class Customer {
    @Id // this makes id PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this makes id autoIncrement
    private int id;

    @Column(nullable = false) // specify constraints to NOTNULL
    private String name;

    private String city;

    @OneToOne
    private User user;

    public Customer() {
    }

    public Customer(int id, String name, User user, String city) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.city = city;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
