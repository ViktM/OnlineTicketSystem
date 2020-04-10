package com.company.ots;

import java.util.List;
import java.util.Scanner;

import static com.company.ots.Customer.register;
import static com.company.ots.Show.listsEachShows;
import static com.company.ots.Venue.initialiseSeatingPlan;

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
                myAccountMenu(customer);
                break;
            case 2:
                listsEachShows(customer);
                break;
            case 3:
                System.out.println("Thanks for visiting, see You again soon!");
                break;
        }
    }

    static void myAccountMenu(Customer customer) {
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
                editDetails(customer);
                break;
            case 3:
                mainMenu(customer);
                break;
        }
    }

    static void editDetails(Customer customer) { //TODO move to menu
        Scanner scanner = new Scanner(System.in);
        System.out.println("Edit details");
        System.out.println("Please choose from the following options");
        System.out.println("1) Change my first name");
        System.out.println("2) Change my last name");
        System.out.println("3) Change my email");
        System.out.println("4) Change my password");
        System.out.println("5) Change my Address");
        System.out.println("6) Back to my account");

        int editDetailsChoice = scanner.nextInt();

        switch (editDetailsChoice) {
            case 1:
                customer.editFirstName(customer);
                break;
            case 2:
                customer.editLastName(customer);
                break;
            case 3:
                customer.editEmail(customer);
                break;
            case 4:
                customer.editPassword(customer);
                break;
            case 5:
                customer.editAddress(customer);
                break;
            case 6:
                myAccountMenu(customer);
                break;
        }
    }

    static void listShowMenu(Customer customer, List<Show> shows) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you would like to learn more about a play, please choose a number " +
                "or press 99 to return to the main menu"); //TODO handle the 99 thing  better

        int chosenShow = scanner.nextInt() - 1;

        if (chosenShow < shows.size()) {
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
                initialiseSeatingPlan(customer);
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

    static void seatingPlanMenu(Customer customer, Venue seatingPlan) {
        Scanner scanner = new Scanner(System.in);
        seatingPlan.print();

        System.out.println("Please choose from the following options");
        System.out.println("1) Select seats for this show");
        System.out.println("2) Back to list of shows");

        int chosenOption = scanner.nextInt();

        switch (chosenOption) {
            case 1:
                selectSeatsMenu(customer, seatingPlan);
                break;
            case 2:
                listsEachShows(customer);
                break;
            case 3:
                break;
        }
    }

    private static void selectSeatsMenu(Customer customer, Venue seatingPlan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, you can choose up to 5 seats.\n" +
                "Please enter the number of seats you'd like to purchase");
        int numberOfTickets = scanner.nextInt();
        int i = 0;
        while (numberOfTickets > i) {
            System.out.println("Please choose seat");
            chooseSeat(seatingPlan);
            i++;
        }
        paymentMenu(customer, seatingPlan);
    }

    private static void paymentMenu(Customer customer, Venue seatingPlan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose from the following options");
        System.out.println("1) Buy tickets");
        System.out.println("2) Cancel tickets, and back to main menu");

        int chosenOption = scanner.nextInt();

        switch (chosenOption){
            case 1:
                System.out.println("buying tickets");
                break;
            case 2:
                mainMenu(customer);
                break;
        }

    }

    private static void chooseSeat(Venue seatingPlan) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of row you would like to sit in:");
        int row = scanner.nextInt();


        System.out.println("Please enter the letter of the seat you would ike to choose:");

        Row aRow = seatingPlan.getRow(row);
        String columnLetter = "";
        while (columnLetter.isEmpty()) {
            columnLetter = scanner.nextLine();
        }
        Seat seat = aRow.getSeat(columnLetter);
        seat.setState(SeatState.HOLD);

        seatingPlan.print();
    }
}
