package com.appconsecurity.esbao.persistence.repositories;

import com.appconsecurity.esbao.persistence.entities.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Long> {

}
