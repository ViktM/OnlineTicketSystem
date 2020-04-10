package com.company.ots.test;

import com.company.ots.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    Customer customer = new Customer("firstName", "lastName", "email", "password", "address");

    @Test
    void getFirstName() {
        assertEquals("firstName", customer.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("lastName", customer.getLastName());
    }

    @Test
    void getEmail() {
        assertEquals("email", customer.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals("password", customer.getPassword());
    }

    @Test
    void getAddress() {
        assertEquals("address", customer.getAddress());
    }
}
