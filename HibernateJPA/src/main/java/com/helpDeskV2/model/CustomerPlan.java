package com.helpDeskV2.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customer_plan")
public class CustomerPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Executive executive;

    @Column(name = "activation_date", nullable = false)
    private LocalDate activationDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    private String coupon;

    @Column(name = "amount_paid")
    private double amountPaid;

    public CustomerPlan() {
    }

    public CustomerPlan(int id, Customer customer, Executive executive, LocalDate activationDate, LocalDate endDate, String coupon, double amountPaid) {
        this.id = id;
        this.customer = customer;
        this.executive = executive;
        this.activationDate = activationDate;
        this.endDate = endDate;
        this.coupon = coupon;
        this.amountPaid = amountPaid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Executive getExecutive() {
        return executive;
    }

    public void setExecutive(Executive executive) {
        this.executive = executive;
    }

    public LocalDate getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(LocalDate activationDate) {
        this.activationDate = activationDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "CustomerPlan{" +
                "id=" + id +
                ", customer=" + customer +
                ", executive=" + executive +
                ", activationDate=" + activationDate +
                ", endDate=" + endDate +
                ", coupon='" + coupon + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
