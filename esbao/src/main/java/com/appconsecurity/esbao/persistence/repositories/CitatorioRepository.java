package com.appconsecurity.esbao.persistence.repositories;

import com.appconsecurity.esbao.persistence.entities.CitatorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitatorioRepository extends JpaRepository<CitatorioEntity,Long> {


}
