/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.repositories.DepartamentoRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bufal
 */
@Service
public class DepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;
    
    public ArrayList<DepartamentoModel> obtenerDepartamento(){
        return (ArrayList<DepartamentoModel>) departamentoRepository.findAll();
    }
    
    public DepartamentoModel guardarDepartamento(DepartamentoModel departamento){
        return departamentoRepository.save(departamento);
    }
    
    public Optional<DepartamentoModel> obtenerPorId(Long id){
        return departamentoRepository.findById(id);
    }
    
    public boolean eliminarEmpleado(Long id){
        try {
            departamentoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    
        
    }
}
