package com.example.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Sejam todos bem vindos";
    }

    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            int numero = (int) (Math.random() * 60);
            numeros.add(numero);
        }
        return numeros.stream().sorted().collect(Collectors.toList());
    }
}
