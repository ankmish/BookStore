package com.assignment.readingisgood.dao;

import com.assignment.readingisgood.models.Customer;
import com.assignment.readingisgood.models.Order;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public void addCustomer(Customer customer) {

    }

    @Override
    public List<Order> getCustomerOrder(String id) {
        return null;
    }
}
