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
public class MarcaCocheEntity {

    /**
     * Id de la marca
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Descripción de la marca
     */
    private Integer id;
    @Column(name = "descripcion")
    private String description;
}
