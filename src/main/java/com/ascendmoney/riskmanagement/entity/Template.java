package com.ascendmoney.riskmanagement.entity;

import com.ascendmoney.riskmanagement.dto.TemplateDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Template  implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String country;

    public Template(TemplateDTO dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.phoneNumber = dto.getPhoneNumber();
        this.country = dto.getCountry();
    }

    public Template() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
