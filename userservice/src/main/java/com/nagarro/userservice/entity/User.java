package com.nagarro.userservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;


@Entity
@Table(name="users")
@Getter
@Setter
public class User {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="userid")
//    private int userId;


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String referenceId;

    @Column(name="name")
    private String userName;

    @Column(name="email")    // to make unique
    private String userEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    private Contact contact;

}