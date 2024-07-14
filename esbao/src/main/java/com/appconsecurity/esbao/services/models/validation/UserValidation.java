package com.appconsecurity.esbao.services.models.validation;

import com.appconsecurity.esbao.persistence.entities.UserEntity;
import com.appconsecurity.esbao.services.models.dtos.ResponseDTO;

public class UserValidation {

    public ResponseDTO validate(UserEntity users){
        ResponseDTO response = new ResponseDTO();

        response.setNumOfErrors(0);
        if (users.getNombre_usuario() == null ||
            users.getNombre_usuario().length() < 3 ||
            users.getNombre_usuario().length() > 15
        ){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El nombre de usuario debe tener entre 3 y 15 caracteres.");
        }

        if (users.getApellido() == null ||
            users.getApellido().length() < 3 ||
            users.getApellido().length() > 30
        ){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El apellido de usuario debe tener entre 3 y 15 caracteres.");
        }

        if (users.getEmail() == null ||
                !users.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
        ){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("El campo email no es correcto");
        }

        if (users.getPassword() == null ||
                !users.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")
        ){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("La contraseña debe tener entre 8 y 16 caracteres, al menos un número, una minúscula y una mayúscula.");
        }

        return response;

    }
}
