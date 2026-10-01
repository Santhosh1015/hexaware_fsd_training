package com.helpDeskV2.model;

import com.helpDeskV2.enums.PlanType;
import jakarta.persistence.*;

@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private PlanType type;

    private double price;

    public Plan() {
    }

    public Plan(int id, PlanType type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlanType getType() {
        return type;
    }

    public void setType(PlanType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                '}';
    }
}
