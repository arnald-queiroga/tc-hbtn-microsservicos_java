package com.example.user.controller;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if (id > 0 && id <= 100)
            return "You have entered valid ID";
        throw new UserIdException(id);
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if (userName.length() > 3 && userName.length() < 15)
            return "You have entered valid USERNAME";
        throw new UserNameException(userName);
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {
        if (cpf.length() > 3 && cpf.length() < 15)
            return "You have entered valid CPF";
        throw new CPFException(cpf);

    }

    public boolean isCPF(String CPF) {
        int lenght = CPF.length();
        if (!(lenght > 3 && lenght < 15))
            return false;
        return true;
    }

} 


