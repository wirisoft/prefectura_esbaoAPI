package com.appconsecurity.esbao.persistence.repositories;

import com.appconsecurity.esbao.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(String email);
}
