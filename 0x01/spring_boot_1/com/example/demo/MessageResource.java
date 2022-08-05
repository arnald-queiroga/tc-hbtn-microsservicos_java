package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login/{user}/{password}")
    public String login(@PathVariable String user, String password){

        if (user.equals(null) && password.equals(null)){
            return "USUÁRIO E SENHA NÃO INFORMADOS";
        } else if (user.length() > 15 && password.length() > 15) {
            return "USUÁRIO E SENHA INVÁLIDOS";

        } else {
            return "LOGIN EFETUADO COM SUCESSO !!!";
        }

    }
}
