package com.project.coches.domain.repository;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    /**
     * Devuelve una lista con todas las marcas de coches
     * @return Lista con marcas de coches
     */
    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional de la marca coche encontrodo
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Elimina una carca coche dada su id
     * @param idBrandCar Id de la marca coche a eliminar
     */
    void delete(Integer idBrandCar);
}
