package com.project.coches.domain.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo de marca coche
 */
@Getter @Setter
public class MarcaCochePojo {

    /**
     * Id de la marca
     */
    private Integer id;
    /**
     * Descripción de la Marca
     */
    private String description;
}
