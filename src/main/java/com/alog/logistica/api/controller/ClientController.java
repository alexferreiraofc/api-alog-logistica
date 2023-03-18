package com.alog.logistica.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {
    @GetMapping("/clientes")
    public String teste() {
        return "Hello Mapping";
    }
}
