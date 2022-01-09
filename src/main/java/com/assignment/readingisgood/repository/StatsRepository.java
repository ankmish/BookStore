package com.assignment.readingisgood.repository;

import com.assignment.readingisgood.models.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public interface StatsRepository extends JpaRepository<Statistics,String> {
    @Query(value = "select month(order_date), sum(price), sum(book_count) from orders where year(order_date) = :year and customer_id = :customerId group by month(order_date)", nativeQuery = true)
    List<Statistics> getStats(@Param("year") String year, @Param("customerId") String customerId);
}