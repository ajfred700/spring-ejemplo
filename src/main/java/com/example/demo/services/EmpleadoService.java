/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.services;

import com.example.demo.models.EmpleadoModel;
import com.example.demo.repositories.EmpleadoRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bufal
 */

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;
    
    public ArrayList<EmpleadoModel> obtenerEmpleado(){
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
    }
    
    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    }
    
    public Optional<EmpleadoModel> obtenerPorId(Long id){
        return empleadoRepository.findById(id);
    }
    
    public boolean eliminarEmpleado(Long id){
        try {
            empleadoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    
        
    }
    }

