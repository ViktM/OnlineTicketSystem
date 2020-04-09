package com.company.ots;

import java.util.Scanner;

class SeatingPlan {
    private static void purchaseTickets(Venue seatingPlan) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome, please choose your seats. You can choose up to 5 seats.\n" +
                "Please enter the number of seats you'd like to purchase");
        int numberOfTickets = scanner.nextInt();
        int i = 0;
        while (numberOfTickets > i) {
            System.out.println("Please choose next seat");
            chooseSeat(seatingPlan);
            i++;
        }
        System.out.println("Cheerio"); //TODO remove later
    }

    private static void chooseSeat(Venue seatingPlan) {
        Scanner scanner = new Scanner(System.in);
        seatingPlan.print();
        System.out.println("Please enter the number of row you would like to sit in:");
        int row = scanner.nextInt();


        System.out.println("Please enter the letter of the seat you would ike to choose:");

        Row aRow = seatingPlan.getRow(row);
        String columnLetter = "";
        while (columnLetter.isEmpty()){
            columnLetter = scanner.nextLine();
        }
        Seat seat = aRow.getSeat(columnLetter);
        seat.setState(SeatState.HOLD);

        seatingPlan.print();
    }

    static Venue intialiseSeatingPlan() {
        String[][] seatingPlan = {
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"}
        };

        Venue venue = new Venue(seatingPlan);
        purchaseTickets(venue);
        return venue;
    }
}
