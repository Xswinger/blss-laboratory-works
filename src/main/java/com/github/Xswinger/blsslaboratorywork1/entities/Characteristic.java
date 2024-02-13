package com.github.Xswinger.blsslaboratorywork1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CHARACTERISTIC")
@Data
public class Characteristic {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String carcaseType;

    @Column(nullable = false)
    private int weight;

    private int liftingCapacity;

    private String engineType;

    private int capacity;

    private int maxPower;

    private String gearboxType;

    private String transmission;

    private String tires;

    private String fuelType;
}
