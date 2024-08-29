package com.example.lab2_20202396.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class AdivinarController {
    @PostMapping("/adivina")
    public String guessLetter(@RequestParam("letra") String letra,
                              @RequestParam("palabra") String palabra,
                              @RequestParam("intentosSobrantes") int intentosSobrantes,
                              @RequestParam("letrasAdivinadas") List<String> letrasAdivinadas,
                              Model model) {
        letrasAdivinadas.add(letra);

        if (!palabra.contains(letra)) {
            intentosSobrantes--;
        }


        if (intentosSobrantes == 0) {
            model.addAttribute("message", "Perdiste la palabra era: " + palabra);
            return "perdiste";
        }

        if (palabra.chars().allMatch(c -> letrasAdivinadas.contains(String.valueOf((char) c)))) {
            model.addAttribute("message", "Ganaste adivinaste la palabra: " + palabra);
            return "ganaste";
        }

        model.addAttribute("palabra", palabra);
        model.addAttribute("intentosSobrantes", intentosSobrantes);
        model.addAttribute("letrasAdivinadas", letrasAdivinadas);

        return "gameplay";
    }

}
