package com.appconsecurity.esbao.services;

import com.appconsecurity.esbao.persistence.entities.UserEntity;
import com.appconsecurity.esbao.services.models.dtos.LoginDTO;
import com.appconsecurity.esbao.services.models.dtos.ResponseDTO;

import java.util.HashMap;

public interface IAuthService {

    public HashMap<String,String> login(LoginDTO login) throws Exception;

    public ResponseDTO register(UserEntity user)throws Exception;
    //public LoginDTO login(LoginDTO loginRequest) throws Exception;
}
