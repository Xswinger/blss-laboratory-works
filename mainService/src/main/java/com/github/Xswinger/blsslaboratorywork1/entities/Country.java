package com.github.Xswinger.blsslaboratorywork1.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "COUNTRY")
@Data
public class Country implements Serializable{
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
}
