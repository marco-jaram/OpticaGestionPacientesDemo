package com.mtec.optica.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    private String email;
    private String phone;
    private String service;
    private String product;

    @Column(columnDefinition = "TEXT")
    private String visitHistory;

    private LocalDate lastVisitDate;
    private LocalDate nextVisitDate;
}
