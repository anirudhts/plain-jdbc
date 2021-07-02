package com.project.repository;

import static org.junit.jupiter.api.Assertions.*;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class CustomerRepositoryTest {

  @Inject EmbeddedApplication application;

  @Inject CustomerRepository customerRepository;

  @Test
  void testConnection() {
    customerRepository.findCustomer();
  }
}
