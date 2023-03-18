package com.alog.logistica.api.controller;


import com.alog.logistica.domain.model.Client;
import com.alog.logistica.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
public class ClientController {

    private ClientRepository clientRepository;

    @GetMapping("/clientes")
    public List<Client> listar() {
        return clientRepository.findAll();
    }
}
