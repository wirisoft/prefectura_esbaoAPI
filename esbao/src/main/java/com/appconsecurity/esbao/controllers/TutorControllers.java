package com.appconsecurity.esbao.controllers;

import com.appconsecurity.esbao.persistence.entities.TutorEntity;
import com.appconsecurity.esbao.services.ITutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.annotation.Validated;
import java.util.Map;
import java.util.zip.DataFormatException;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://vps-4243804-x.dattaweb.com")
@RestController
@RequestMapping("/api/tutor")
public class TutorControllers {

    @Autowired
    ITutorService tutorService;

    @PostMapping("/create")
    public ResponseEntity<TutorEntity> createTutor(@RequestBody TutorEntity tutor) {
        try {
            TutorEntity createdTutor = tutorService.createTutor(tutor);
            return new ResponseEntity<>(createdTutor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<TutorEntity>> getAllTutors() {
        try {
            List<TutorEntity> tutors = tutorService.getAllTutors();
            return new ResponseEntity<>(tutors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TutorEntity> getTutorById(@PathVariable Long id) {
        try {
            Optional<TutorEntity> tutor = tutorService.getTutorById(id);
            return tutor.map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TutorEntity> updateTutor(@PathVariable Long id, @RequestBody TutorEntity newTutor) {
        try {
            TutorEntity updatedTutor = tutorService.updateTutor(id, newTutor);
            if (updatedTutor != null) {
                return new ResponseEntity<>(updatedTutor, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, String>> deleteTutor(@PathVariable Long id) {
        try {
            HashMap<String, String> response = tutorService.deleteTutor(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
