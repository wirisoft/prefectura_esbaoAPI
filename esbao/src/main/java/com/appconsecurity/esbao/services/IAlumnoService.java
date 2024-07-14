package com.appconsecurity.esbao.services;

import com.appconsecurity.esbao.persistence.entities.AlumnoEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface IAlumnoService {

    public AlumnoEntity createAlumno(AlumnoEntity alumnoEntity);
    public List<AlumnoEntity> getAllAlumnos();
    public Optional<AlumnoEntity> getAlumnoById(Long id);
    public AlumnoEntity updateAlumno(Long id, AlumnoEntity newAlumno);
    public HashMap<String,String> deleteAlumno(Long id);

}
