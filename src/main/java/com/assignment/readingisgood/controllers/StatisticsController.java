package com.assignment.readingisgood.controllers;

import com.assignment.readingisgood.exceptions.BookAlreadyPresent;
import com.assignment.readingisgood.exceptions.InvalidQuantity;
import com.assignment.readingisgood.models.Book;
import com.assignment.readingisgood.models.BookResponse;
import com.assignment.readingisgood.models.OrderResponse;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class StatisticsController {
//    @RequestMapping(value = "/statistics/filter={customerId}&{year}",method = RequestMethod.GET)
//    @ResponseBody
//    public BookResponse getStatistics(@PathVariable String customerId, @PathVariable String year) {
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate;
//        Date endDate;
//        OrderResponse orderResponse;
//        try {
//            startDate = format.parse(sDate);
//            endDate = format.parse(eDate);
//    }
}
