package com.helpDeskV2.model;

import com.helpDeskV2.enums.Priority;
import com.helpDeskV2.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String subject;

    @Column(length = 1000)
    private String issue;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="executive_id")
    private Executive executive;

    public Ticket() {
    }

    public Ticket(String subject, String issue, Priority priority, Status status) {
        this.subject = subject;
        this.issue = issue;
        this.priority = priority;
        this.status = status;
    }

    public Ticket(int id, String subject, String issue, Instant createdAt, Priority priority, Status status, Customer customer, Executive executive) {
        this.id = id;
        this.subject = subject;
        this.issue = issue;
        this.createdAt = createdAt;
        this.priority = priority;
        this.status = status;
        this.customer = customer;
        this.executive = executive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", issue='" + issue + '\'' +
                ", createdAt=" + createdAt +
                ", priority=" + priority +
                ", status=" + status +
                ", customer=" + customer +
                ", executive=" + executive +
                '}';
    }
}
