/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/SpringFramework/Controller.java to edit this template
 */
package com.Cartelera.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class CarteleraController {

    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }

    @GetMapping("/InicioSesion")
    public String InicioSesion(Model model) {
        model.addAttribute("attribute", "value");
        return "InicioSesion";
    }

    @GetMapping("/Registro")
    public String Registro(Model model) {
        model.addAttribute("attribute", "value");
        return "Registro";
    }

    @GetMapping("/cartelera")
    public String cartelera(Model model) {
        model.addAttribute("attribute", "value");
        return "cartelera";
    }

    @GetMapping("/Promociones")
    public String Promociones(Model model) {
        model.addAttribute("attribute", "value");
        return "Promociones";
    }

    @GetMapping("/Dulceria")
    public String Dulceria(Model model) {
        model.addAttribute("attribute", "value");
        return "Dulceria";
    }

    @GetMapping("/CinePlus")
    public String CinePlus(Model model) {
        model.addAttribute("attribute", "value");
        return "CinePlus";
    }

    @GetMapping("/Horarios")
    public String Horarios(Model model) {
        model.addAttribute("attribute", "value");
        return "Horarios";
    }

    @GetMapping("/Carrito")
    public String Carrito(Model model) {
        model.addAttribute("attribute", "value");
        return "Carrito";
    }
}
