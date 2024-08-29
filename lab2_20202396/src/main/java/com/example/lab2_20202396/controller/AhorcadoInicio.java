package com.example.lab2_20202396.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AhorcadoInicio {


    @GetMapping(value = "/juegoVacio")
    public String formularioInicio(){
        return "formulario";
    }
}
