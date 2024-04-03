package com.nagarro.cinservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CinDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String PanNumber;
    @Lob
    private byte[] cinCertificateImage;
    private String cinNumber;
    private String entityName;
    private String dateOfRegistration;
    private boolean status;
    private String EntityCategory;
    private String classOfCompany;
    private String location;

}
