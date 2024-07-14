package com.appconsecurity.esbao.services;

import com.appconsecurity.esbao.persistence.entities.UserEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface IUserService {

    public UserEntity createUser(UserEntity userEntity);
    public List<UserEntity> getAllUsers();
    public Optional<UserEntity> getUserById(Long id);
    public UserEntity updateUser(Long id, UserEntity newUser);
    public HashMap<String,String> deleteUser(Long id);

//    public List<UserEntity> findAllUsers();
//    public UserEntity findById(Long id);
//    public UserEntity save (UserEntity userEntity);
//    public void delete(Long id);

}
