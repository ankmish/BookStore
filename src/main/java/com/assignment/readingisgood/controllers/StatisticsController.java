package com.assignment.readingisgood.controllers;

import com.assignment.readingisgood.models.CustomerResponse;
import com.assignment.readingisgood.models.Statistics;
import com.assignment.readingisgood.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping(value = "/statistics/filter={customerId}&{year}",method = RequestMethod.GET)
    @ResponseBody
    public List<Statistics> getStatistics(@PathVariable String customerId, @PathVariable String year) {
        try {
            return statisticsService.getStats(year, customerId);
        }catch(Exception e) {
            new CustomerResponse("Error occured: ",e.getMessage());
        }
        return null;
    }
}
