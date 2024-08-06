package com.appconsecurity.esbao.controllers;

import com.appconsecurity.esbao.persistence.entities.BitacoraEntity;
import com.appconsecurity.esbao.services.IBitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://vps-4243804-x.dattaweb.com")
@RestController
@RequestMapping("/api/bitacora")
public class BitacoraControllers {

    @Autowired
    IBitacoraService bitacoraService;

    @PostMapping("/create")
    public ResponseEntity<BitacoraEntity> createBitacora(@RequestBody BitacoraEntity bitacora) {
        try {
            BitacoraEntity createdBitacora = bitacoraService.createBitacora(bitacora);
            return new ResponseEntity<>(createdBitacora, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BitacoraEntity>> getAllBitacoras() {
        try {
            List<BitacoraEntity> bitacoras = bitacoraService.getAllBitacoras();
            return new ResponseEntity<>(bitacoras, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BitacoraEntity> getBitacoraById(@PathVariable Long id) {
        try {
            Optional<BitacoraEntity> bitacora = bitacoraService.getBitacoraById(id);
            return bitacora.map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BitacoraEntity> updateBitacora(@PathVariable Long id, @RequestBody BitacoraEntity newBitacora) {
        try {
            BitacoraEntity updatedBitacora = bitacoraService.updateBitacora(id, newBitacora);
            if (updatedBitacora != null) {
                return new ResponseEntity<>(updatedBitacora, HttpStatus.OK);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, String>> deleteBitacora(@PathVariable Long id) {
        try {
            HashMap<String, String> response = bitacoraService.deleteBitacora(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
