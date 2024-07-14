package com.appconsecurity.esbao.services.impl;


import com.appconsecurity.esbao.persistence.entities.BitacoraEntity;
import com.appconsecurity.esbao.persistence.repositories.BitacoraRepository;
import com.appconsecurity.esbao.services.IBitacoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class BitacoraServiceImpl implements IBitacoraService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BitacoraServiceImpl.class);

    @Autowired
    BitacoraRepository bitacoraRepository;


    @Override
    public BitacoraEntity createBitacora(BitacoraEntity bitacoraEntity) {
        try {
            return bitacoraRepository.save(bitacoraEntity);
        }catch (Exception e){
            LOGGER.error("Error while creating bitacora: {}", e.getMessage());
            throw new RuntimeException("Error creating bitacora");
        }
    }

    @Override
    public List<BitacoraEntity> getAllBitacoras() {
        try {
            return bitacoraRepository.findAll();
        } catch (Exception e){
            LOGGER.error("Erro while fetching all bitacoras: {}", e.getMessage());
            throw new RuntimeException("Error fetching bitacoras");
        }
    }

    @Override
    public Optional<BitacoraEntity> getBitacoraById(Long id) {
        try {
            return bitacoraRepository.findById(id);
        } catch (Exception e){
            LOGGER.error("Error while fetching bitacora by ID: {}", e.getMessage());
            throw new RuntimeException("Error fetching bitacoras by ID");
        }
    }

    @Override
    public BitacoraEntity updateBitacora(Long id, BitacoraEntity newBitacora) {
        try {
            Optional<BitacoraEntity> existingBitacoraOpt = bitacoraRepository.findById(id);
            if (existingBitacoraOpt.isPresent()){
                BitacoraEntity existingBitacora = existingBitacoraOpt.get();
                existingBitacora.setDia_bitacora(newBitacora.getDia_bitacora());
                existingBitacora.setHora_bitacora(newBitacora.getHora_bitacora());
                existingBitacora.setMes_bitacora(newBitacora.getMes_bitacora());
                existingBitacora.setAnio(newBitacora.getAnio());
                existingBitacora.setInsidencia(newBitacora.getInsidencia());
                existingBitacora.setPdf_bitacora(newBitacora.getPdf_bitacora());
                existingBitacora.setEvidencia_img(newBitacora.getEvidencia_img());

                return bitacoraRepository.save(existingBitacora);
            }
            throw new RuntimeException("Bitacora not found");
        }catch (Exception e){
            LOGGER.error("Error while updating Bitacora: {}", e.getMessage());
            throw new RuntimeException("Error updating Bitacora");
        }
    }

    @Override
    public HashMap<String, String> deleteBitacora(Long id) {
        try{
            HashMap<String,String> response = new HashMap<>();
            response.put("message", "Bitacora deleted successfully!");
            bitacoraRepository.deleteById(id);
            return response;
        } catch (Exception e){
            LOGGER.error("Error while deleting Bitacora: {}", e.getMessage());
            throw new RuntimeException("Error deleting Bitacora");
        }
    }


//    private static final Logger logger = LoggerFactory.getLogger(BitacoraServiceImpl.class);
//    @Override
//    public Optional<BitacoraEntity> getBitacoraById(Long id) {
//        logger.info("Buscando bitácora con ID: {}", id);
//        Optional<BitacoraEntity> bitacora = bitacoraRepository.findById(id);
//        if (bitacora.isPresent()) {
//            logger.info("Bitácora encontrada: {}", bitacora.get());
//        } else {
//            logger.warn("No se encontró bitácora con ID: {}", id);
//        }
//        return bitacora;
//    }


}
