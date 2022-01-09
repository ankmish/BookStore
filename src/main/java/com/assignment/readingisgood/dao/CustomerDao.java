package com.assignment.readingisgood.dao;

import com.assignment.readingisgood.models.Customer;
import com.assignment.readingisgood.models.Order;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);
    List<Order> getCustomerOrder(String id);
}
