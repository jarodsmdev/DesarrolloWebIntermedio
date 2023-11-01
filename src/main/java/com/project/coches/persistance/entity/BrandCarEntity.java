package com.project.coches.persistance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidad de Marca Coche
 */
@Getter @Setter
@Entity
@Table(name = "marca_coche")
public class BrandCarEntity {

    /**
     * Id de la marca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Descripción de la marca
     */
    @Column(name = "descripcion")
    private String description;
}
