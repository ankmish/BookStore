package com.assignment.readingisgood.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "CUSTOMER")
public class Customer {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="email_id")
    private String email_id;
    @Column(name="mobile_no")
    private String mobile_no;
    public Customer(String name,String email_id,String mobile_no){
        this.email_id = email_id;
        this.name = name;
        this.mobile_no = mobile_no;
    }
}
