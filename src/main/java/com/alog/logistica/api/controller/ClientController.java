package com.alog.logistica.api.controller;


import com.alog.logistica.domain.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class ClientController {
    @GetMapping("/clientes")
    public List<Client> listar() {

        var cl1 = new Client();
        cl1.setId(1L);
        cl1.setName("Alex");
        cl1.setEmail("alex@mail.com");
        cl1.setPhone("48 9999-0000");


        var cl2 = new Client();
        cl2.setId(2L);
        cl2.setName("Maria");
        cl2.setEmail("maria@mail.com");
        cl2.setPhone("48 7777-9999");

        return Arrays.asList(cl1, cl2);
    }
}
