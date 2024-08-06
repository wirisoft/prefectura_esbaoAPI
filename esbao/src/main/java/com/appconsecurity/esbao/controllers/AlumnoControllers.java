package com.appconsecurity.esbao.controllers;

import com.appconsecurity.esbao.persistence.entities.AlumnoEntity;
import com.appconsecurity.esbao.services.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumno")
@CrossOrigin(origins = "http://200.58.106.203:80")
public class AlumnoControllers {

    @Autowired
    IAlumnoService alumnoService;

    @PostMapping("/create")
    public ResponseEntity<AlumnoEntity> createAlumno(@RequestBody AlumnoEntity alumno) {
        try {
            AlumnoEntity createdAlumno = alumnoService.createAlumno(alumno);
            return new ResponseEntity<>(createdAlumno, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AlumnoEntity>> getAllAlumnos() {
        try {
            List<AlumnoEntity> alumnos = alumnoService.getAllAlumnos();
            return new ResponseEntity<>(alumnos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AlumnoEntity> getAlumnoById(@PathVariable Long id) {
        try {
            Optional<AlumnoEntity> alumno = alumnoService.getAlumnoById(id);
            return alumno.map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AlumnoEntity> updateAlumno(@PathVariable Long id, @RequestBody AlumnoEntity newAlumno) {
        try {
            AlumnoEntity updatedAlumno = alumnoService.updateAlumno(id, newAlumno);
            if (updatedAlumno != null) {
                return new ResponseEntity<>(updatedAlumno, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, String>> deleteAlumno(@PathVariable Long id) {
        try {
            HashMap<String, String> response = alumnoService.deleteAlumno(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
