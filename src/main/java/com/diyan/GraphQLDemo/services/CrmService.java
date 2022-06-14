package com.diyan.GraphQLDemo.services;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CrmService {
    record Customer(Integer id, String name){}

    public Customer getCustomerById(Integer id){
        return new Customer(id, Math.random() > .5 ? "Name1" : "Name2");
    }

    public Collection<Customer> getCustomers(){
        return List.of(new Customer(1, "Name1"), new Customer(2, "Name2"));
    }
}
