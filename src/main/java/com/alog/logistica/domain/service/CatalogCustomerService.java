package com.alog.logistica.domain.service;

import com.alog.logistica.domain.exception.BusinessException;
import com.alog.logistica.domain.model.Customer;
import com.alog.logistica.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class CatalogCustomerService {

    private CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer customer) {
        boolean emailInUse = customerRepository.findByEmail(customer.getEmail())
                .stream()
                .anyMatch(customerExists -> !customerExists.equals(customer));

        if (emailInUse) {
            throw new BusinessException("Email already in use! Try another email");
        }

        return customerRepository.save(customer);
    }

    @Transactional
    public void delete(Long customer_id) {
        customerRepository.deleteById(customer_id);
    }


}
