package com.appconsecurity.esbao.services.impl;

import com.appconsecurity.esbao.persistence.entities.AlumnoEntity;
import com.appconsecurity.esbao.persistence.repositories.AlumnoRepository;
import com.appconsecurity.esbao.services.IAlumnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlumnoServiceImpl.class);

    @Autowired
    AlumnoRepository alumnoRepository;


    @Override
    public AlumnoEntity createAlumno(AlumnoEntity alumnoEntity) {
        try {
            return alumnoRepository.save(alumnoEntity);
        }catch (Exception e){
            LOGGER.error("Error while creating alumno: {}", e.getMessage());
            throw new RuntimeException("Error creating alumno");
        }
    }

    @Override
    public List<AlumnoEntity> getAllAlumnos() {
        try {
            return alumnoRepository.findAll();
        }catch (Exception e){
            LOGGER.error("Error while fetching all alumnos: {}", e.getMessage());
            throw new RuntimeException("Error fetching alumnos");
        }
    }

    @Override
    public Optional<AlumnoEntity> getAlumnoById(Long id) {
        try {
            return alumnoRepository.findById(id);
        }catch (Exception e){
            LOGGER.error("Error while fetching alumno by ID: {}", e.getMessage());
            throw new RuntimeException("Error fetching alumno by ID");
        }
    }

    @Override
    public AlumnoEntity updateAlumno(Long id, AlumnoEntity newAlumno) {
        try {
            Optional<AlumnoEntity> existingAlumnoOpt = alumnoRepository.findById(id);
            if (existingAlumnoOpt.isPresent()){
                AlumnoEntity existingAlumno = existingAlumnoOpt.get();
                existingAlumno.setNombre_alumno(newAlumno.getNombre_alumno());
                existingAlumno.setPrimer_apellido(newAlumno.getPrimer_apellido());
                existingAlumno.setSegundo_apellido(newAlumno.getSegundo_apellido());
                existingAlumno.setTurno(newAlumno.getTurno());
                existingAlumno.setGrado(newAlumno.getGrado());
                existingAlumno.setGrupo(newAlumno.getGrupo());
                existingAlumno.setMatricula(newAlumno.getMatricula());
                existingAlumno.setArea_especialidad(newAlumno.getArea_especialidad());
                existingAlumno.setTelefono_alumno(newAlumno.getTelefono_alumno());

                return alumnoRepository.save(existingAlumno);
            }
            throw new RuntimeException("Alumno not found");
        }catch (Exception e){
            LOGGER.error("Error while updating alumno: {}", e.getMessage());
            throw new RuntimeException("Error updating alumno");
        }
    }

    @Override
    public HashMap<String, String> deleteAlumno(Long id) {
        try {
            HashMap<String,String> response = new HashMap<>();
            response.put("menssage", "Alumno deleted successfully!");
            alumnoRepository.deleteById(id);
            return response;
        }catch (Exception e){
            LOGGER.error("Error while deleting alumno: {}", e.getMessage());
            throw new RuntimeException("Error deleting alumno");
        }
    }
}
