package com.nagarro.kycservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "UserPanDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] panCardImage;
    private String panNumber;
    private String userId;
    private LocalDate dateOfIncorporation;
    private String name;
}
