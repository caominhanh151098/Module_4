package com.example.billmanagement.service.customer;

import com.example.billmanagement.model.Customer;
import com.example.billmanagement.repository.CustomerRepository;
import com.example.billmanagement.service.customer.request.CustomerSaveProductImportRequest;
import com.example.billmanagement.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerSaveProductImportRequest> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerRepository.findAll()
                .stream()
                .map(e -> AppUtils.mapper.map(e, CustomerSaveProductImportRequest.class))
                .collect(Collectors.toList());
    }
}
