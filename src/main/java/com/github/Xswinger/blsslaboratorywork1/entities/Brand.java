package com.github.Xswinger.blsslaboratorywork1.entities;

import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "BRAND")
@Data
public class Brand {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
    private Country country;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private Set<CarLineUp> lineups;
}
