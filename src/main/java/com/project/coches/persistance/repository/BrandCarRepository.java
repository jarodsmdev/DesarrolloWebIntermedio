package com.project.coches.persistance.repository;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.repository.IBrandCarRepository;
import com.project.coches.persistance.entity.BrandCarEntity;
import com.project.coches.persistance.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor //Crea constructor con los atributos final
@Repository
public class BrandCarRepository implements IBrandCarRepository {

    /**
     * Crud de marca coche
     */
    private final IBrandCarCrudRepository iBrandCarCrudRepository;

    /**
     * Mapper de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;


    /**
     * Devuelve una lista con todas las marcas de coches
     * @return lista con marcas de coches
     */
    @Override
    public List<BrandCarPojo> getAll() {
        return iBrandCarMapper.toMarcasCochePojo(iBrandCarCrudRepository.findAll());
    }

    /**
     * Devuelve una marca de coche dada su id
     * @param id Id de marca coche
     * @return Optional de marca coche encontrado
     */
    @Override
    public Optional<BrandCarPojo> getBrandCar(Integer id) {
        return iBrandCarCrudRepository.findById(id)
                //.map(brandCarEntity -> iBrandCarMapper.toMarcaCochePojo(brandCarEntity)); //LAMBDA
                .map(iBrandCarMapper::toMarcaCochePojo); //Método por REFERENCIA (PROGRAMACIÓN FUNCIONAL)
    }

    /**
     * Guarda una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guardada
     */
    @Override
    public BrandCarPojo save(BrandCarPojo newBrandCar) {
        BrandCarEntity brandCarEntity =  iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));
    }

    /**
     * Elimina una marca de coche dada su id
     * @param idBrandCar Id de la marca coche a eliminar
     */
    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);
    }
}
