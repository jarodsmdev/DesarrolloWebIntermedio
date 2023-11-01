package com.project.coches.domain.service;

import com.project.coches.domain.pojo.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

    List<BrandCarPojo> getAll();

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional del la marca coche encontrado
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Actualiza una marca coche
     * @param newBrandCarPojo Marca coche a actualizar
     * @return Marca coche actualizada
     */
    Optional<BrandCarPojo> update(BrandCarPojo newBrandCarPojo);

    /**
     * Elimina uan marca coche dada su id
     * @param idBrandCar Id de la marca del coche a eliminar
     * @return true si se eliminó, false de lo contrario
     */
    boolean delete(Integer idBrandCar);
}
