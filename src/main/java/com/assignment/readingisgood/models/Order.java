package com.assignment.readingisgood.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class Order {
    private final String id;
    private final String customer_id;
    private final Date order_date;
    private final List<BookQuantity> bookList;
    private final double price;
}
