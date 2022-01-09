package com.assignment.readingisgood.repository;

import com.assignment.readingisgood.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "SELECT count(*) FROM CUSTOMER c where c.EMAIL_ID=:email_id", nativeQuery = true)
    int getCustomerByEmailId(@Param("email_id") String email_id);

//    @Query("insert into customer (email_id, mobile_no, name, id) values (?, ?, ?, ?)")
//    void saveQ(String email_id,String mobile_no,String name,String id);
}
