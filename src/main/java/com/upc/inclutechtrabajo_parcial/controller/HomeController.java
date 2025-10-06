package com.upc.inclutechtrabajo_parcial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

    @GetMapping("/")
    public String home() {
        return "🚀 INCLUTECH API - Trabajo Parcial está funcionando correctamente! ";
    }

    @GetMapping("/health")
    public String health() {
        return "✅ API Health Check - OK - ";
    }

}