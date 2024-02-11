package com.github.Xswinger.blsslaboratorywork1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MODEL")
public class Model {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne
    @MapsId
    private CarClass carClass;

    @ManyToOne
    private Country country;

}