package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.ICustomerRepository;
import com.example.patterns_banking.services.proxy.ICustomerOperations;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final ICustomerRepository customerRepository;
  private final ICustomerOperations proxy;

  public CustomerService(ICustomerRepository customerRepository, ICustomerOperations proxy) {
    this.customerRepository = customerRepository;
    this.proxy = proxy;
  }

  public Customer create(CustomerDTO customerDTO) {
    Customer customer = Customer
      .builder()
      .name(customerDTO.getName())
      .email(customerDTO.getEmail())
      .build();

    if  (!proxy.isValidEmail(customer.getEmail())) {
        throw new IllegalArgumentException("El dominio 'yahoo.com' no está permitido.");
    }
    return customerRepository.save(customer);
  }
}
