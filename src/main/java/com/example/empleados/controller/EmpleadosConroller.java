package com.example.empleados.controller;

import com.example.empleados.entity.EmpleadosEntity;
import com.example.empleados.service.EmpleadosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadosConroller {
    
    @Autowired
    private EmpleadosService eService;
    
    @GetMapping("/list")
    public List<EmpleadosEntity> list(){
        return eService.listAll();
    }
    
    @GetMapping("/{id}")
    public EmpleadosEntity byId(@PathVariable long id){
        return eService.findById(id).get();
    }
    
    @PostMapping()
    public String create(@RequestBody EmpleadosEntity emp){
        return eService.create(emp);
    }
    
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        return eService.delete(id);
    }    
}
