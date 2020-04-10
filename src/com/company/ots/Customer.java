package com.company.ots;

import java.util.Scanner;

import static com.company.ots.Menu.mainMenu;
import static com.company.ots.Menu.myAccountMenu;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;

    public Customer(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
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
        System.out.println("Welcome to OTS " + firstName + "!");

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
            login(customer); //TODO option to re-register
        }

        mainMenu(customer);
    }

    void editAddress(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current last name is: " + customer.getAddress());
        System.out.println("Please enter your new address:");

        String newAddress = scanner.nextLine();

        customer.setAddress(newAddress);

        System.out.println("Your address has been edited!");
        myAccountMenu(customer);
    }

    void editPassword(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current password is: " + customer.getPassword());
        System.out.println("Please enter your new password:");

        String newPassword = scanner.nextLine();

        customer.setPassword(newPassword);

        System.out.println("Your password has been edited!");
        myAccountMenu(customer);
    }

    void editEmail(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current email is: " + customer.getEmail());
        System.out.println("Please enter your new email:");

        String newEmail = scanner.nextLine();

        customer.setEmail(newEmail);

        System.out.println("Your email has been edited!");
        myAccountMenu(customer);
    }

    void editLastName(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current last name is: " + customer.getLastName());
        System.out.println("Please enter your new last name:");

        String newLastName = scanner.nextLine();

        customer.setLastName(newLastName);

        System.out.println("Your last name has been edited!");
        myAccountMenu(customer);
    }

    void editFirstName(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your current first name is: " + customer.getFirstName());
        System.out.println("Please enter your new first name:");

        String newFirstName = scanner.next();

        customer.setFirstName(newFirstName);

        System.out.println("Your first name has been edited!");
        myAccountMenu(customer);
    }

    void viewDetails(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("My details");
        System.out.println("First Name: " + customer.getFirstName());
        System.out.println("Last Name: " + customer.getLastName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Password: ********"); //TODO show password on request
        System.out.println("Address: " + customer.getAddress());

        System.out.println("Press 0 to return to My account");

        int backToMyAccount = scanner.nextInt();
        if (backToMyAccount == 0) {
            myAccountMenu(customer);
        } else {
            myAccountMenu(customer); //TODO handle this user journey
        }
    }
}
