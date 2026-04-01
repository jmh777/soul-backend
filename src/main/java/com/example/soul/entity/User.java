package com.example.soul.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String skillOffer;
    private String skillWant;

    public User() {
    }

    public Long getId() {
        return id;
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

    public String getSkillOffer() {
        return skillOffer;
    }

    public void setSkillOffer(String skillOffer) {
        this.skillOffer = skillOffer;
    }

    public String getSkillWant() {
        return skillWant;
    }

    public void setSkillWant(String skillWant) {
        this.skillWant = skillWant;
    }
}