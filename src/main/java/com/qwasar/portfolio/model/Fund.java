package com.qwasar.portfolio.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private LocalDateTime createdAt;

    public Fund() {}
}
