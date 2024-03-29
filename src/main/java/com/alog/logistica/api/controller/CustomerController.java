package com.alog.logistica.api.controller;


import com.alog.logistica.domain.model.Customer;
import com.alog.logistica.domain.repository.CustomerRepository;
import com.alog.logistica.domain.service.CatalogCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository customerRepository;
    private CatalogCustomerService catalogCustomerService;



    @GetMapping
    public List<Customer> listar() {
        // list all customers
        return customerRepository.findAll();
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<Customer> find(@PathVariable Long customer_id) {
        // find by id, check if exists, return ok if success or notFound if fail.
        return customerRepository.findById(customer_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@Valid @RequestBody Customer customer) {
        return catalogCustomerService.save(customer);
    }

    @PutMapping("/{customer_id}")
    public ResponseEntity<Customer> update(@PathVariable Long customer_id, @Valid @RequestBody Customer customer) {
        // check if exists id to update, if false, return notfound.
        if (!customerRepository.existsById(customer_id)) {
            return ResponseEntity.notFound().build();
        }
        // success updating customer by id and saving
        customer.setId(customer_id);
        customer = catalogCustomerService.save(customer);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{customer_id}")
    public ResponseEntity<Void> delete(@PathVariable Long customer_id) {
        // check if exists id, if not, return notfound.
        if (!customerRepository.existsById(customer_id)) {
            return ResponseEntity.notFound().build();
        }
        // success deleting with void content aka noContent
        catalogCustomerService.delete(customer_id);
        return ResponseEntity.noContent().build();
    }

}
