package com.assignment.readingisgood.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Statistics {
    private int month;
    private int orderCount;
    private int bookCount;
    private double purchaseAmount;
}
