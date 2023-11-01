package com.project.coches.controller;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.domain.service.IBrandCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador rest de Marca coche
 */
@RestController
@RequestMapping("/marcas-coches")
@RequiredArgsConstructor
public class BrandCarController {

    /**
     * Servicio de marca coche
     */
    private final IBrandCarService iBrandCarService;

    /**
     * Devuelve lista de marcas coches
     * @return HttpCode OK con lista de marca coche
     */
    @GetMapping()
    public ResponseEntity<List<BrandCarPojo>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(iBrandCarService.getAll());
        //return new Response<>(iBrandCarService.getAll(), HttpStatus.OK); //Alternativa para crear RESPONSEENTITY
    }

    /**
     * Devuelve marca coche dado su id
     * @param id Id de la marca coche a buscar
     * @return HttpCode OK si la encuentra, HttpCode NOT FOUND de lo contrario
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<BrandCarPojo> getBrandCar(@PathVariable Integer id){
        return ResponseEntity.of(iBrandCarService.getBrandCar(id));
    }

    /**
     * Crea una nueva marca coche
     * @param brandCarPojoNew Marca coche a crear
     * @return HttpCode CREATED si la guarda correctamente, HttpCode BADREQUEST de lo contratio
     */
    @PostMapping
    public ResponseEntity<BrandCarPojo> save(@RequestBody BrandCarPojo brandCarPojoNew){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iBrandCarService.save(brandCarPojoNew));
        }catch (Exception e) {
            //Corregir porque no esta mandando excepcion
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Actualiza una marca coche
     * @param brandCarPojoUpdate Marca coche actualizada
     * @return Optional con marca coche actualizada
     */
    @PatchMapping
    public ResponseEntity<BrandCarPojo> update(@RequestBody BrandCarPojo brandCarPojoUpdate){

        return ResponseEntity.of(iBrandCarService.update(brandCarPojoUpdate));
    }

    /**
     * Elimina una marca coche dada su id
     * @param id Id de la marca coche a Eliminar
     * @return HttpCode OK si la elimina, HttpCode NOTFOUND si no existe
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        return new ResponseEntity<>(this.iBrandCarService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
