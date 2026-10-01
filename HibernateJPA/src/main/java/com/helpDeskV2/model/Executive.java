package com.helpDeskV2.model;

import com.helpDeskV2.enums.JobTitle;
import jakarta.persistence.*;

@Entity

public class Executive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "job_title" , nullable = false)
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @OneToOne
    private User user;

    public Executive() {
    }

    public Executive(int id, String name, JobTitle jobTitle, User user) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.user = user;
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

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
