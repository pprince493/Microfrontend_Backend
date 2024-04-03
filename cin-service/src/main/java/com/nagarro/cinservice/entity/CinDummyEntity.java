package com.nagarro.cinservice.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "CinDummy")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinDummyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String cinNumber;   //Primary key
    private String PanNumber;
    private String entityName;
    private String dateOfRegistration;
    private boolean status;
    private String EntityCategory;
    private String classOfCompany;

}
