package com.example.deliverypetproject.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class Logger {

    @Pointcut("execution(public * com.example.deliverypetproject.controller.UserController.getAllUsers())")
    public void LogDatabaseOperation(){

    }
}
