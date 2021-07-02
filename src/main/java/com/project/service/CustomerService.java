package com.project.service;

import com.project.models.Account;
import com.project.models.Customer;
import com.project.repository.CustomerRepository;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class CustomerService {

  private final CustomerRepository customerRepository;

  @Inject
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public void getCustomer() {
    customerRepository.findCustomer();
  }

    public List<Account> getAccountsForACustomer(Long accountId) {
      return customerRepository.findAccountDetails(accountId);
    }

  public List<Customer> getCustomerByName(String name) {
      return customerRepository.getCustomerByName(name);

  }
}
