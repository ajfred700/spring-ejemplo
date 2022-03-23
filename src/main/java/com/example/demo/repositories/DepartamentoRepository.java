/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositories;

import com.example.demo.models.DepartamentoModel;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author bufal
 */
public interface DepartamentoRepository  extends CrudRepository<DepartamentoModel, Long>{
    
}
