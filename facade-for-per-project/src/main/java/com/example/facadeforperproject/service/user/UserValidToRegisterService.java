package com.example.facadeforperproject.service.user;

import com.example.facadeforperproject.exception.UserValidationException;
import com.example.facadeforperproject.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
public class UserValidToRegisterService {

    public boolean isValid(BindingResult bindingResult){
        boolean isUserValid = false;
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            throw new UserValidationException("Save-operation","User is not valid to save",fieldErrors);
        }else{
            isUserValid =true;
        }
        return isUserValid;
    }
}
