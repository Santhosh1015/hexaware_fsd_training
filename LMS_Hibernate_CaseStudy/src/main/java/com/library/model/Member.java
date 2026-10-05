package com.library.model;

import com.library.enums.Genre;
import com.library.enums.MembershipType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false , length = 255)
    private String name;

    @Column(nullable = false , length = 255 , unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MembershipType membershipType;

    @Column(name = "joined_at")
    @CreationTimestamp
    private Instant joinedAt;

    public Member() {
    }

    public Member(long id, String name, String email, MembershipType membershipType, Instant joinedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.membershipType = membershipType;
        this.joinedAt = joinedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Instant getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Instant joinedAt) {
        this.joinedAt = joinedAt;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", membershipType=" + membershipType +
                ", joinedAt=" + joinedAt +
                '}';
    }
}
