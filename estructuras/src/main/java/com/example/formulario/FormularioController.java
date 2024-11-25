package com.example.formulario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormularioController {

    @GetMapping("/")
    public String mostrarFormulario() {
        return "formulario"; // Nombre del archivo formulario.html
    }

    @PostMapping("/procesar")
    public String procesarFormulario(
            @RequestParam("nombre") String nombre,
            @RequestParam("edad") int edad,
            @RequestParam("color") String color,
            Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("edad", edad);
        model.addAttribute("color", color);
        model.addAttribute("mayorEdad", edad >= 18 ? "Mayor de edad" : "Menor de edad");
        return "resultado"; // Nombre del archivo resultado.html
    }
}
