package com.github.Xswinger.blsslaboratorywork1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CHARACTERISTIC")
@Data
public class Characteristic {
    
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Model model;

    @Column(name = "carcase", nullable = false)
    private String carcaseType;

    @Column(nullable = false)
    private int weight;

    @Column(name = "lifting_capacity")
    private int liftingCapacity;

    @Column(name = "engine_type")
    private String engineType;

    private int capacity;

    @Column(name = "max_power")
    private int maxPower;

    @Column(name = "gearbox_type")
    private String gearboxType;

    private String transmission;

    private String tires;

    @Column(name = "fuel_type")
    private String fuelType;
}
