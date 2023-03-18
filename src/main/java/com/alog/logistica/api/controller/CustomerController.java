package com.alog.logistica.api.controller;


import com.alog.logistica.domain.model.Customer;
import com.alog.logistica.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> listar() {
        return customerRepository.findAll();
    }
}
