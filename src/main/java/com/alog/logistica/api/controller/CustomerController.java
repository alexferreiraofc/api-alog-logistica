package com.alog.logistica.api.controller;


import com.alog.logistica.domain.model.Customer;
import com.alog.logistica.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> listar() {
        return customerRepository.findAll();
    }
    @GetMapping("/{customer_id}")
    public ResponseEntity<Customer> find(@PathVariable Long customer_id) {
        return customerRepository.findById(customer_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{customer_id}")
    public ResponseEntity<Customer> update(@PathVariable Long customer_id, @RequestBody Customer customer) {
        if(!customerRepository.existsById(customer_id)) {
            return ResponseEntity.notFound().build();
        }

        customer.setId(customer_id);
        customer = customerRepository.save(customer);

        return ResponseEntity.ok(customer);
    }

}
