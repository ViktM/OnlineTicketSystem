package com.company.ots;

import java.util.Scanner;

class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

    private Customer(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    private String getFirstName() {
        return firstName;
    }
    private String getLastName() {
        return lastName;
    }
    private String getEmail() {
        return email;
    }
    private String getPassword() {
        return password;
    }
    private String getAddress() {
        return address;
    }

    static Customer register() {
        String firstName;
        String lastName;
        String email;
        String password;
        String address;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your firstname");
        firstName = scanner.nextLine();
        System.out.println("Please enter your lastname");
        lastName = scanner.nextLine();
        System.out.println("Please enter your email");
        email = scanner.nextLine();
        System.out.println("Please enter your password");
        password = scanner.nextLine();
        System.out.println("Please enter your address");
        address = scanner.nextLine();
        System.out.println("Welcome " + firstName + "!");

        return new Customer(firstName, lastName, email, password, address);
    }

    void login(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        String loginEmail;
        String loginPassword;
        System.out.println("Please enter your email");
        loginEmail = scanner.nextLine();
        System.out.println("Please enter your password");
        loginPassword = scanner.nextLine();

        if (loginEmail.equals(customer.getEmail()) && loginPassword.equals(customer.getPassword())) {
            System.out.println("Welcome back " + customer.getFirstName());
        } else {
            System.out.println(
                    "Your credentials were invalid or not found in our system. Please try again or register");
            register();
        }

        mainMenu(customer);
    }

    private void mainMenu(Customer customer) {
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

    private void myAccount(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(customer.getFirstName() + "'s account");
        System.out.println("Please choose from the following options");
        System.out.println("1) View my details");
        System.out.println("2) Edit my details");
        System.out.println("3) Back to main menu");

        int myAccountChoice = scanner.nextInt();

        switch (myAccountChoice) {
            case 1:
                viewDetails(customer);
                break;
            case 2:
                editDetails(customer);
                break;
            case 3:
                mainMenu(customer);
                break;
        }
    }

    private void editDetails(Customer customer) {
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
                editFirstName(customer);
                break;
            case 2:
                editLastName(customer);
                break;
            case 3:
                System.out.println("email");
                break;
            case 4:
                System.out.println("password");
                break;
            case 5:
                System.out.println("address");
                break;
            case 6:
                myAccount(customer);
                break;
        }
    }

    private void editLastName(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current last name is: " + customer.getFirstName());
        System.out.println("Please enter your new last name:");

        String newLastName = scanner.nextLine();

        Customer newCustomer = new Customer(
                customer.getFirstName(),
                newLastName,
                customer.getEmail(),
                customer.getPassword(),
                customer.getAddress());

        System.out.println("Your last name has been edited!");
        myAccount(newCustomer);
    }

    private void editFirstName(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current first name is: " + customer.getFirstName());
        System.out.println("Please enter your new first name:");

        String newFirstName = scanner.next();

        Customer newCustomer = new Customer(
                newFirstName,
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getAddress());

        System.out.println("Your first name has been edited!");
        myAccount(newCustomer);
    }


    private void viewDetails(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("My details");
        System.out.println("First Name: " + customer.getFirstName());
        System.out.println("Last Name: " + customer.getLastName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Password: ********"); //TODO show password on request
        System.out.println("Address: " + customer.getAddress());

        System.out.println("Press 1 to return to My account");

        int backToMyAccount = scanner.nextInt();
        if (backToMyAccount == 1) {
            myAccount(customer);
        } else {
            myAccount(customer); //TODO handle this user journey
        }
    }
}
