package com.Xswinger.uazService.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MODEL")
@Data
public class Model {

    @Id
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CLASS", nullable = false)
    private String carClass;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "LINE_UP", nullable = false)
    private String lineUp;
}