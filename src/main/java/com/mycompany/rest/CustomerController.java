package com.mycompany.rest;

import java.util.concurrent.atomic.AtomicLong;

import com.mycompany.Application;
import com.mycompany.domain.Customer;
import com.mycompany.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.mycompany.transferObject.CustomerDTO;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong COUNTER = new AtomicLong();
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    @Autowired
    CustomerService customerService;


    @ResponseBody
    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDTO> getByID(@RequestParam(value="id", required=false) Long id) {
        Customer customer = customerService.findById(id);
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName());
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

}
