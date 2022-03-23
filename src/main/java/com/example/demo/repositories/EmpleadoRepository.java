/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.EmpleadoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bufal
 */
@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel, Long> {
    
}
