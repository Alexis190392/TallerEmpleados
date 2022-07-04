package com.example.empleados.dao;

import com.example.empleados.entity.EmpleadosEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosDao extends CrudRepository<EmpleadosEntity, Object> {
    
}
