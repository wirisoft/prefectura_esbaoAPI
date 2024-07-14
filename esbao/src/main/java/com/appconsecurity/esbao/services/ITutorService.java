package com.appconsecurity.esbao.services;

import com.appconsecurity.esbao.persistence.entities.TutorEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface ITutorService {

    public TutorEntity createTutor(TutorEntity tutorEntity);
    public List<TutorEntity> getAllTutors();
    public Optional<TutorEntity> getTutorById(Long id);
    public TutorEntity updateTutor(Long id, TutorEntity newTutor);
    public HashMap<String,String> deleteTutor(Long id);

//    public List<TutorEntity> findAllTutors();
//
//    public TutorEntity findById(Long id);
//
//    public TutorEntity save (TutorEntity tutorEntity);
//
//    public void delete(Long id);

}
