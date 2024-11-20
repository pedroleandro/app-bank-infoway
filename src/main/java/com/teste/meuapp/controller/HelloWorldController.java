package com.teste.meuapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String root() {
        return "";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Olá, mundo!";
    }
}
