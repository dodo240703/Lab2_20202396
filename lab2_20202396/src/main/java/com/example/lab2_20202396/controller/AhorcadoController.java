package com.example.lab2_20202396.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class AhorcadoController {

    private final Map<String, List<String>> diccionario = new HashMap<>();

    public void diccionarioooo() {
        diccionario.put("animales", Arrays.asList("leon", "elefante", "tigre", "cebra", "jirafa", "delfin", "ballena", "gorila", "panda", "aguila", "hipopotamo", "koala", "lobo", "oso", "canguro"));
        diccionario.put("frutas", Arrays.asList("manzana", "platano", "kiwi", "mango", "pera", "uva", "fresa", "naranja", "piña", "sandia", "cereza", "melon", "papaya", "limon", "higo"));
        diccionario.put("paises", Arrays.asList("mexico", "canada", "brasil", "españa", "francia", "italia", "alemania", "japon", "australia", "argentina", "chile", "peru", "estados unidos", "china", "india"));
    }

    @PostMapping (value = "/inicio")
    public String startGame(@RequestParam("longitud") int longitud,
                            @RequestParam("intentos") int intentos,
                            @RequestParam("tema") String tema,
                            Model model) {
        List<String> palabras = diccionario.get(tema);

        List<String> filtradoPalbras = palabras.stream().filter(word -> word.length() == longitud).collect(Collectors.toList());

        if (filtradoPalbras.isEmpty()) {
            model.addAttribute("error", "No hay palabras disponibles para esa longitud.");
            return "formulario";
        }

        String palabraEscogida = filtradoPalbras.get(new Random().nextInt(filtradoPalbras.size()));

        model.addAttribute("palabra", palabraEscogida);
        model.addAttribute("intentos", intentos);
        model.addAttribute("letrasAdivinadas", new ArrayList<>());
        model.addAttribute("intentosSobrantes", intentos);

        return "gameplay";
    }
}

