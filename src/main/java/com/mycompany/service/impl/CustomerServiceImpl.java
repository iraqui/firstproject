package com.mycompany.service.impl;

import com.mycompany.domain.Customer;
import com.mycompany.repository.CustomerRepository;
import com.mycompany.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by iraquil on 31.05.2016.
 */
@Service
public class CustomerServiceImpl implements CustomerService {


    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
}
