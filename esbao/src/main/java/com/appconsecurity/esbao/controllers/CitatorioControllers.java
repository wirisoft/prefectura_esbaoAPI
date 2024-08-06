package com.appconsecurity.esbao.controllers;

import com.appconsecurity.esbao.persistence.entities.CitatorioEntity;
import com.appconsecurity.esbao.services.ICitatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://vps-4243804-x.dattaweb.com")
@RestController
@RequestMapping("/api/citatorio")
public class CitatorioControllers {

    @Autowired
    ICitatorioService citatorioService;

    @PostMapping("/create")
    public ResponseEntity<CitatorioEntity> createCitatorio(@RequestBody CitatorioEntity citatorio) {
        try {
            CitatorioEntity createdCitatorio = citatorioService.createCitatorio(citatorio);
            return new ResponseEntity<>(createdCitatorio, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CitatorioEntity>> getAllCitatorios() {
        try {
            List<CitatorioEntity> citatorios = citatorioService.getAllCitatorios();
            return new ResponseEntity<>(citatorios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CitatorioEntity> getCitatorioById(@PathVariable Long id) {
        try {
            Optional<CitatorioEntity> citatorio = citatorioService.getCitatorioById(id);
            return citatorio.map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CitatorioEntity> updateCitatorio(@PathVariable Long id, @RequestBody CitatorioEntity newCitatorio) {
        try {
            CitatorioEntity updatedCitatorio = citatorioService.updateCitatorio(id, newCitatorio);
            if (updatedCitatorio != null) {
                return new ResponseEntity<>(updatedCitatorio, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, String>> deleteCitatorio(@PathVariable Long id) {
        try {
            HashMap<String, String> response = citatorioService.deleteCitatorio(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
