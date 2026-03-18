package com.qwasar.portfolio.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int amount;
    private LocalDateTime createdAt;

    public Investment() {}
}