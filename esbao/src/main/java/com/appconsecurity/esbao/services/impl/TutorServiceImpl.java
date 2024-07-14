package com.appconsecurity.esbao.services.impl;

import com.appconsecurity.esbao.persistence.entities.TutorEntity;
import com.appconsecurity.esbao.persistence.repositories.TutorRepository;
import com.appconsecurity.esbao.services.ITutorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TutorServiceImpl implements ITutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TutorServiceImpl.class);

    @Autowired
    TutorRepository tutorRepository;


    @Override
    public TutorEntity createTutor(TutorEntity tutorEntity) {
        try {
            return tutorRepository.save(tutorEntity);
        } catch (Exception e) {
            LOGGER.error("Error while creating tutor: {}", e.getMessage());
            throw new RuntimeException("Error creating tutor");
        }
    }

    @Override
    public List<TutorEntity> getAllTutors() {
        try {
            return tutorRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("Error while fetching all tutors: {}", e.getMessage());
            throw new RuntimeException("Error fetching tutors");
        }
    }

    @Override
    public Optional<TutorEntity> getTutorById(Long id) {
        try {
            return tutorRepository.findById(id);
        } catch (Exception e) {
            LOGGER.error("Error while fetching tutor by ID: {}", e.getMessage());
            throw new RuntimeException("Error fetching tutor by ID");
        }
    }

    @Override
    public TutorEntity updateTutor(Long id, TutorEntity newTutor) {
        try {
            Optional<TutorEntity> existingTutorOpt = tutorRepository.findById(id);
            if (existingTutorOpt.isPresent()) {
                TutorEntity existingTutor = existingTutorOpt.get();
                existingTutor.setNombre_tutor(newTutor.getNombre_tutor());
                existingTutor.setTipo_tutor(newTutor.getTipo_tutor());
                existingTutor.setTelefono_tutor(newTutor.getTelefono_tutor());
                existingTutor.setEmail_tutor(newTutor.getEmail_tutor());

                return tutorRepository.save(existingTutor);
            }
            throw new RuntimeException("Tutor not found");
        } catch (Exception e) {
            LOGGER.error("Error while updating tutor: {}", e.getMessage());
            throw new RuntimeException("Error updating tutor");
        }
    }

    @Override
    public HashMap<String, String> deleteTutor(Long id) {
        try {
            HashMap<String, String> response = new HashMap<>();
            response.put("message", "Tutor deleted successfully!");
            tutorRepository.deleteById(id);
            return response;
        } catch (Exception e) {
            LOGGER.error("Error while deleting tutor: {}", e.getMessage());
            throw new RuntimeException("Error deleting tutor");
        }
    }
}
