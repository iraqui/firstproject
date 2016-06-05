package com.mycompany.service;

import com.mycompany.domain.Customer;


/**
 * Created by iraquil on 31.05.2016.
 */
public interface CustomerService {
    Customer findById(Long id);
    Customer save(Customer entity);
    Iterable<Customer> findAll();
}
