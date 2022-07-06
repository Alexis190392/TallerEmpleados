package com.example.empleados.service;

import com.example.empleados.dao.EmpleadosDao;
import com.example.empleados.entity.EmpleadosEntity;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosService {
    @Autowired
    private EmpleadosDao eDao;
    
    @Transactional
    public String create(EmpleadosEntity emp){
        eDao.save(emp);
        return "Empleado" + emp.getId() + "guardado";
        
    }
    
    public List<EmpleadosEntity> listAll(){
        return (List<EmpleadosEntity>) eDao.findAll();
    }
    
    public Optional<EmpleadosEntity> findById(Long id){
        return eDao.findById(id);
    }
    
    @Transactional
    public String modifyById(EmpleadosEntity emp){
        //EmpleadosEntity empMod = findById(emp.getId()).get();
        /*
            validaciones...
        */
        create(emp);
        return "Empleado" + emp.getId() + "modificado";
    }
    
    @Transactional
    public String delete(long id){
        /*
            validaciones...
        */
        eDao.delete(findById(id).get());
        return "Empleado" + id + "eliminado";
    }
}
