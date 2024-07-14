package com.appconsecurity.esbao.services.impl;

import com.appconsecurity.esbao.persistence.entities.CitatorioEntity;
import com.appconsecurity.esbao.persistence.repositories.CitatorioRepository;
import com.appconsecurity.esbao.services.ICitatorioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CitatorioServiceImpl implements ICitatorioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CitatorioServiceImpl.class);

    @Autowired
    CitatorioRepository citatorioRepository;


    @Override
    public CitatorioEntity createCitatorio(CitatorioEntity citatorioEntity) {
        try{
            return citatorioRepository.save(citatorioEntity);
        } catch (Exception e){
            LOGGER.error("Error whole creating citatorio: {}", e.getMessage());
            throw new RuntimeException("Error creating citatorio");
        }
    }

    @Override
    public List<CitatorioEntity> getAllCitatorios() {
        try {
            return citatorioRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching all citatorios: {}", e.getMessage());
            throw new RuntimeException("Error fetching citatorios");
        }
    }

    @Override
    public Optional<CitatorioEntity> getCitatorioById(Long id) {
        try {
            return citatorioRepository.findById(id);
        } catch (Exception e) {
            LOGGER.error("Error while fetching citatorio by ID: {}", e.getMessage());
            throw new RuntimeException("Error fetching citatorio by ID");
        }
    }

    @Override
    public CitatorioEntity updateCitatorio(Long id, CitatorioEntity newCitatorio) {
        try {
            Optional<CitatorioEntity> existingCitatorioOpt = citatorioRepository.findById(id);
            if (existingCitatorioOpt.isPresent()) {
                CitatorioEntity existingCitatorio = existingCitatorioOpt.get();
                existingCitatorio.setNombre_citatorio(newCitatorio.getNombre_citatorio());
                existingCitatorio.setAsunto(newCitatorio.getAsunto());
                existingCitatorio.setDia_citatorio(newCitatorio.getDia_citatorio());
                existingCitatorio.setMes_citatorio(newCitatorio.getMes_citatorio());
                existingCitatorio.setAno_citatorio(newCitatorio.getAno_citatorio());
                existingCitatorio.setHora_citatorio(newCitatorio.getHora_citatorio());
                existingCitatorio.setFecha_citatorio(newCitatorio.getFecha_citatorio());
                existingCitatorio.setDepartamento(newCitatorio.getDepartamento());
                existingCitatorio.setPdf_citatorio(newCitatorio.getPdf_citatorio());
                existingCitatorio.setUsers(newCitatorio.getUsers());


                return citatorioRepository.save(existingCitatorio);
            }
            throw new RuntimeException("Citatorio not found");
        } catch (Exception e) {
            LOGGER.error("Error while updating citatorio: {}", e.getMessage());
            throw new RuntimeException("Error updating citatorio");
        }
    }

    @Override
    public HashMap<String, String> deleteCitatorio(Long id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Citatorio deleted successfully!");
            citatorioRepository.deleteById(id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting citatorio: {}", e.getMessage());
            throw new RuntimeException("Error deleting citatorio");
        }
    }
}
