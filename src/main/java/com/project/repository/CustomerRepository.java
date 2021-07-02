package com.project.repository;

import com.project.models.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;

@Singleton
public class CustomerRepository {

  @Inject private final DataSource dataSource;

  public CustomerRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void findCustomer() {
    try {
      Connection connection = dataSource.getConnection();

      PreparedStatement preparedStatement =
          connection.prepareStatement("select * from customers FETCH NEXT 5 ROWS ONLY");
      ResultSet resultSet = preparedStatement.executeQuery();

      List<Customer> customers = new ArrayList<>();
      while (resultSet.next()) {
        customers.add(
            new Customer(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3)));
      }
      System.out.println(customers);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
