/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.models.EmpleadoModel;
import com.example.demo.services.EmpleadoService;
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
@RequestMapping("api")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;
    
    @GetMapping("/empleados")
    public ArrayList<EmpleadoModel> obtenerEmpleados(){
        return empleadoService.obtenerEmpleado();
        
    }
    
    @GetMapping("/empleados/{id}")
    public Optional<EmpleadoModel> obtenerEmpleadoPorId(@PathVariable Long id){
        return this.empleadoService.obtenerPorId(id);
    }
    
    @PostMapping("empleados")
    public EmpleadoModel guardarEmpleado(@RequestBody EmpleadoModel empleado){
        return this.empleadoService.guardarEmpleado(empleado);
    }
    @PutMapping("/empleados/{id}")
    public EmpleadoModel update(@PathVariable(value = "id") Long id, @RequestBody EmpleadoModel empleado)
       {

        if (id == null) {
            
             System.out.println("revise los datos");
            
        }

        Optional<EmpleadoModel> e = empleadoService.obtenerPorId(id);
        e.get().setNombre(empleado.getNombre());
        e.get().setDireccion(empleado.getDireccion());
        e.get().setTelefono(empleado.getTelefono());
        

        EmpleadoModel emp = empleadoService.guardarEmpleado(empleado);
        return null;

       
    }

    
    
    @DeleteMapping ("/empleados/{id}")
    public String eliminarPorId(@PathVariable Long id){
        boolean ok = this.empleadoService.eliminarEmpleado(id);
        if(ok){
            return "Se ha eliminado el empleado " + id;
        }else{
            return "No se pudo eliminar el empleado" + id;
        }
        
    }
    
    
    
}
