package com.helpdesk.model;

import com.helpdesk.enums.Priority;
import com.helpdesk.enums.Status;

import java.time.LocalDate;

public class Ticket {
    private int id;
    private String subject;
    private String issue;
    private LocalDate createdAt;
    private Priority priority;
    private Status status;

    private Customer customer; // foreign key in sql here as a object;

    public Ticket() {
    }

    public Ticket(int id, String subject, String issue, LocalDate createdAt, Priority priority, Status status, Customer customer) {
        this.id = id;
        this.subject = subject;
        this.issue = issue;
        this.createdAt = createdAt;
        this.priority = priority;
        this.status = status;
        this.customer = customer;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
                '}';
    }
}
