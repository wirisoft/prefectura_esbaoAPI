package com.appconsecurity.esbao.services;

import com.appconsecurity.esbao.persistence.entities.CitatorioEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface ICitatorioService {

    public CitatorioEntity createCitatorio(CitatorioEntity citatorioEntity);
    public List<CitatorioEntity> getAllCitatorios();
    public Optional<CitatorioEntity> getCitatorioById(Long id);
    public CitatorioEntity updateCitatorio(Long id, CitatorioEntity newCitatorio);
    public HashMap<String,String> deleteCitatorio(Long id);


//    public List<CitatorioEntity> findAllCitatorios();
//
//    public CitatorioEntity findById(Long id);
//
//    public CitatorioEntity save(CitatorioEntity citatorioEntity);
//
//    public void delete(Long id);

}
