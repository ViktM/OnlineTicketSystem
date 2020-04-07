package com.company.ots;

import java.util.Scanner;

class Menu {

    static void mainMenu(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose from the following options");
        System.out.println("1) See my account");
        System.out.println("2) See our current shows");
        System.out.println("3) Log out of OTS");

        int mainMenuChoice = scanner.nextInt();

        switch (mainMenuChoice) {
            case 1:
                myAccount(customer);
                break;
            case 2:
                System.out.println("Upcoming shows");
                break;
            case 3:
                System.out.println("Thanks for visiting, see You again soon!");
                break;
        }
    }

    static void myAccount(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(customer.getFirstName() + "'s account");
        System.out.println("Please choose from the following options");
        System.out.println("1) View my details");
        System.out.println("2) Edit my details");
        System.out.println("3) Back to main menu");

        int myAccountChoice = scanner.nextInt();

        switch (myAccountChoice) {
            case 1:
                customer.viewDetails(customer);
                break;
            case 2:
                customer.editDetails(customer);
                break;
            case 3:
                mainMenu(customer);
                break;
        }
    }
}
