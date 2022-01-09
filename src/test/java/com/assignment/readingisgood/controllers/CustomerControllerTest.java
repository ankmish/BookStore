package com.assignment.readingisgood.controllers;

import com.assignment.readingisgood.models.Customer;
import com.assignment.readingisgood.models.CustomerResponse;
import com.assignment.readingisgood.models.Response;
import com.assignment.readingisgood.services.CustomerServices;
import com.assignment.readingisgood.services.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@WebMvcTest(value = CustomerController.class)
@WithMockUser
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServices customerServices;

    @MockBean
    private OrderService orderService;

    String id = UUID.randomUUID().toString();
    Customer mockCustomer = new Customer("Piyush Gupta", "guptapiyush963@gmail.com","7015775512");
    //List<Course> courseList = Collections.singletonList(mockCourse);
    //CustomerResponse mockCustomerAPIResponse = new CustomerResponse("Success",id);
    @Test
    public void addNewCustomer() throws Exception {
//        Mockito.when(customerServices.addCustomers(new Customer(Mockito.anyString(),Mockito.anyString(),Mockito.anyString()))).thenReturn(id);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers/add").accept(MediaType.APPLICATION_JSON).content(mockCustomer.toString()).contentType(MediaType.APPLICATION_JSON);
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//        System.out.println("RESULT: " + result.getResponse().getContentAsString());
        //Response expected = new CustomerResponse(200,"Success",id);
        //String expected = "{status_code: 200,description: \"Success\",customer_id: \""+id+"\"}";
        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
    }
}
