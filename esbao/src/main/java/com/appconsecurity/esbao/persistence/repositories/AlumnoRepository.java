package com.appconsecurity.esbao.persistence.repositories;

import com.appconsecurity.esbao.persistence.entities.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long> {


}
