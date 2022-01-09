package com.assignment.readingisgood.services;

import com.assignment.readingisgood.exceptions.BookNotFound;
import com.assignment.readingisgood.exceptions.InvalidQuantity;
import com.assignment.readingisgood.exceptions.OrderNotFound;
import com.assignment.readingisgood.exceptions.OutOfStockException;
import com.assignment.readingisgood.models.Book;
import com.assignment.readingisgood.models.BookQuantity;
import com.assignment.readingisgood.models.Order;
import com.assignment.readingisgood.models.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OrderService {
    private final Map<String, Order> orderMap;

    @Autowired
    private BookService bookService;

    @Autowired
    private CustomerServices customerServices;

    public OrderService() {
        this.orderMap = new HashMap<>();
    }

    public String bookOrder(OrderRequest orderRequest) throws InvalidQuantity, BookNotFound, OutOfStockException {
        List<BookQuantity> bookList = orderRequest.getBookList();
        String customer_id = orderRequest.getCustomer_id();
        if(customerServices.validateCustomer(customer_id)){
            for(BookQuantity b:bookList){
                if(b.getQuantity() < 0)
                    throw new InvalidQuantity("Book id: " + b.getBookId() + " is having an invalid quantity.");
                Integer actualQuantity = bookService.getQuantity(b.getBookId());
                if(actualQuantity < b.getQuantity()){
                    throw new OutOfStockException("Book id: " + b.getBookId() + " is having " + actualQuantity+ " quantity and you wanted "+ b.getQuantity()+ " quantity.");
                }
            }
            double price = 0.0;
            for(BookQuantity b:bookList){
                Book book = bookService.getBook(b.getBookId());
                price += book.getPrice()*b.getQuantity();
                bookService.updateQuantity(b.getBookId(),b.getQuantity());
            }
            String order_id = UUID.randomUUID().toString();
            Order order = new Order(order_id,orderRequest.getCustomer_id(), new Date(),bookList,price);
            orderMap.put(order_id,order);
            return order_id;
        }else{
            return "Customer Id: " + customer_id +" not found.";
        }

    }
    public Order getOrderById(String order_id) throws OrderNotFound {
        if(orderMap.containsKey(order_id)){
            return orderMap.get(order_id);
        }else{
            throw new OrderNotFound("Order not found with id: "+ order_id);
        }
    }
    public List<Order> getOrderByDate(Date startDate, Date endDate) {
        return orderMap.values().stream().filter(order -> (order.getOrder_date().equals(startDate) || order.getOrder_date().after(startDate)) && (order.getOrder_date().before(endDate) || order.getOrder_date().equals(endDate))).collect(Collectors.toList());
    }

    public List<Order> getCustomerOrders(String customerId) {
        return orderMap.values().stream().filter(order -> order.getCustomer_id().equals(customerId)).collect(Collectors.toList());
    }
}
