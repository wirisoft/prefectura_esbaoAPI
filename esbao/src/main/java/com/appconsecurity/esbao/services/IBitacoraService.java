package com.appconsecurity.esbao.services;

import com.appconsecurity.esbao.persistence.entities.BitacoraEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface IBitacoraService {

    public BitacoraEntity createBitacora(BitacoraEntity bitacoraEntity);
    public List<BitacoraEntity> getAllBitacoras();
    public Optional<BitacoraEntity> getBitacoraById(Long id);
    public BitacoraEntity updateBitacora(Long id, BitacoraEntity newBitacora);
    public HashMap<String,String> deleteBitacora(Long id);


//    public List<BitacoraEntity> findAllBitacoras();

//    public BitacoraEntity findById(Long id);

//    public BitacoraEntity save (BitacoraEntity bitacoraEntity);

//    public void delete(Long id);

}
