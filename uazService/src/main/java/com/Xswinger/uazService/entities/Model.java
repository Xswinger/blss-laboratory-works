package com.Xswinger.uazService.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MODEL")
@Data
public class Model {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column
    private String CarClass;
    @Column
    private String Brand;
    @Column
    private String country;
    @Column
    private String lineUp;
}