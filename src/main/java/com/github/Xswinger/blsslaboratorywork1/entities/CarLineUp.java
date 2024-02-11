package com.github.Xswinger.blsslaboratorywork1.entities;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CAR_LINEUP")
@Data
public class CarLineUp {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "LINEUP_ID", referencedColumnName = "ID")
    private Set<Model> models;
}
