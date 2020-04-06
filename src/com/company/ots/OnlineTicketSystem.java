package com.company.ots;

import static com.company.ots.Customer.register;

public class OnlineTicketSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Online Ticket System! Please create an account!");
        Customer customer = register();

        System.out.println("Cheerio, please login now");
        customer.login(customer);

        System.out.println("cool beans"); //TODO remove this

//      Once the app has been linked to a database, give the possibility to login for registered customers //TODO
//        if (customerChoose to login) {
//            customer.login();
//        } else {
//            register();
//        }
    }
}
