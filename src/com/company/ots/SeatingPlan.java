package com.company.ots;

import java.util.Scanner;

class SeatingPlan {
    private static void purchaseTickets(String[][] seatingPlan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome, please choose your seats. You can choose up to 5 seats.\n" +
                "Please enter the number of seats you'd like to purchase");
        int numberOfTickets = scanner.nextInt();
        int i = 0;
        while (numberOfTickets > i) {
            System.out.println("Please choose next seat");
            chooseSeat(scanner, seatingPlan);
            i++;
        }
        System.out.println("Cheerio"); //TODO remove later
    }

    private static void chooseSeat(Scanner scanner, String[][] seatingPlan) {
        System.out.println("Please enter the number of row you would like to sit in:");
        int row = scanner.nextInt();

        System.out.println("Please enter the letter of the seat you would ike to choose:");
        String columnLetter = scanner.next();

        int column = 0;

        switch (columnLetter) {
            case "A":
                column = 0;
                break;
            case "B":
                column = 1;
                break;
            case "C":
                column = 2;
                break;
            case "D":
                column = 3;
                break;
            case "E":
                column = 4;
                break;
            case "F":
                column = 5;
                break;
        }

        seatingPlan[row - 1][column] = "H";

        printBoard(seatingPlan);
    }

    static String[][] intialiseSeatingPlan() {
        String[][] seatingPlan = {
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"}
        };
        printBoard(seatingPlan);
        purchaseTickets(seatingPlan);
        return seatingPlan;
    }

    private static void printBoard(String[][] seatingPlan) {
        int b = 1;
        for (String[] strings : seatingPlan) {
            System.out.println(b++);
            for (int j = 0; (strings != null && j < strings.length); j++)
                System.out.print(strings[j] + " ");
            System.out.println();
        }
    }
}
