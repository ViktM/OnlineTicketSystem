package com.company.ots;

import java.util.List;
import java.util.Scanner;

import static com.company.ots.Customer.register;
import static com.company.ots.SeatingPlan.intialiseSeatingPlan;
import static com.company.ots.Show.listsEachShows;

class Menu {
    static void welcomeMenu() {
        System.out.println("Welcome to the Online Ticket System! Please create an account!");
        Customer customer = register();
        System.out.println("Cheerio, please login now");
        customer.login(customer);
    }

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
                listsEachShows(customer);
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

    static void listShowMenu(Customer customer, List<Show> shows) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you would like to learn more about a play, please choose a number " +
                "or press 99 to return to the main menu"); //TODO handle the 99 thing  better

        int chosenShow = scanner.nextInt() - 1;

        if (chosenShow < shows.size()){
            System.out.println(shows.get(chosenShow).getTitle());
            System.out.println(shows.get(chosenShow).getDescription());
            System.out.println(shows.get(chosenShow).getDate());
        } else {
            mainMenu(customer);
        }
        showMenu(customer);
    }

    private static void showMenu(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose from the following options");
        System.out.println("1) See seating plan for this show");
        System.out.println("2) Back to list of shows");
        System.out.println("3) Back to main menu");

        int choosenOption = scanner.nextInt();

        switch (choosenOption) {
            case 1:
                intialiseSeatingPlan();
                //TODO continue from here
                break;
            case 2:
                listsEachShows(customer);
                break;
            case 3:
                mainMenu(customer);
                break;
        }
    }
}
