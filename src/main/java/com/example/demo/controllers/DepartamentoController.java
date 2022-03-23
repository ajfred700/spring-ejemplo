/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.services.DepartamentoService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bufal
 */
@RestController
@RequestMapping ("api")
public class DepartamentoController {
    @Autowired
    DepartamentoService departamentoService;
    
    @GetMapping("/departamentos")
    public ArrayList<DepartamentoModel> mostrarDepartamentos(){
        return departamentoService.obtenerDepartamento();
    }
    
    @GetMapping("/departamentos/{id}")
    public Optional<DepartamentoModel> obtenerEmpleadoPorId(@PathVariable Long id){
        return this.departamentoService.obtenerPorId(id);
    }
    
    @PostMapping("/departamentos")
    public DepartamentoModel guardarDepartamento(@RequestBody DepartamentoModel departamento){
        return this.departamentoService.guardarDepartamento(departamento);
    }
    @PutMapping("/departamentos/{id}")
    public DepartamentoModel update(@PathVariable(value = "id") Long id, @RequestBody DepartamentoModel departamento)
       {

        if (id == null) {
            
             System.out.println("revise los datos");
            
        }

        Optional<DepartamentoModel> e = departamentoService.obtenerPorId(id);
        e.get().setNombre(departamento.getNombre());
       
        

        DepartamentoModel depa = departamentoService.guardarDepartamento(departamento);
        return null;

       
    }
    
    
    
    @DeleteMapping ("/departamentos/{id}")
    public String eliminarPorId(@PathVariable Long id){
        boolean ok = this.departamentoService.eliminarEmpleado(id);
        if(ok){
            return "Se ha eliminado el departamento " + id;
        }else{
            return "No se pudo eliminar el departamento" + id;
        }
        
    }
    
    
}
