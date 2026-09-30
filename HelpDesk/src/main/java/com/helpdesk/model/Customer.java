package com.helpdesk.model;

import com.helpdesk.enums.Plan;

public class Customer {
    private int id;
    private String name;
    private int age;
    private Plan plan;

    private User user;

    public Customer() {
    }

    public Customer(int id, String name, int age, Plan plan) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.plan = plan;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", plan=" + plan +
                '}';
    }
}
