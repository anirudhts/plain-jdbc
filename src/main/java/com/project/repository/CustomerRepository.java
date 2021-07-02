package com.project.repository;

import com.project.models.Account;
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

    @Inject
    private final DataSource dataSource;

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

    public List<Account> findAccountDetails(Long accountId) {
        List<Account> account = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement("select a.account_id, a.account_type, a.branch, c.customer_id, c.customer_name, c.phone_number from accounts a " +
                            "inner join customers c on c.customer_id = a.customer_id where account_id = ?");
            preparedStatement.setLong(1, accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer(resultSet.getLong(4), resultSet.getString(5), resultSet.getString(6));
                account.add(
                        new Account(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), customer));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return account;
    }

    public Customer findCustomerById(Long customerId) {
        Customer customer = null;
        try {
            Connection connection = dataSource.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from customers where customer_id = ?");
            preparedStatement.setLong(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            customer = new Customer(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));

            System.out.println(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    public List<Customer> getCustomerByName(String name) {
        System.out.println(name);
        List<Customer> customer = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from customers where customer_name = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer.add(new Customer(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3)));
            }
            System.out.println(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
}
