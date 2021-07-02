package com.project.controller;

import com.project.models.Account;
import com.project.models.Customer;
import com.project.service.CustomerService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;

import javax.inject.Inject;
import java.util.List;

@Controller("/customer")
public class CustomerController {

  private final CustomerService customerService;

  @Inject
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @Get("/")
  public HttpResponse get() {
    customerService.getCustomer();
    return HttpResponse.ok();
  }

  @Get("/accounts/{accountId}")
  public List<Account> getAccountsForACustomer(@PathVariable Long accountId) {
     return customerService.getAccountsForACustomer(accountId);

  }

  @Get("/searchByName")
  public List<Customer> getCustomerByName(@QueryValue String name) {
    return customerService.getCustomerByName(name);
  }
}
