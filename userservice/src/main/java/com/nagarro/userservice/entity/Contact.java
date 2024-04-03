package com.nagarro.userservice.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name="contacts")
@Setter
@Getter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contact_id")
    private int contactId;

    @Column(name="countryCode")
    private String countryCode;

    @Column(name="country")
    private String country;

    @Column(name="digits")
    private String digits;

    @Column(name="active")
    private boolean active;


}



