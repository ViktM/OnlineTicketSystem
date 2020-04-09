package com.company.ots;


import java.util.HashMap;
import java.util.Map;

import static com.company.ots.Menu.seatingPlanMenu;

public class Venue {
    private Map<Integer, Row> rows = new HashMap<>();

    public Venue(String[][] seatingPlan) {
        for (int rowNumber = 0; rowNumber < seatingPlan.length; rowNumber++) {
            String[] row = seatingPlan[rowNumber];
            Row venueRow = new Row();
            rows.put(rowNumber,venueRow);
            for (int seatNumber = 0; seatNumber < row.length; seatNumber++) {
                String seatId = row[seatNumber];
                Seat seat = new Seat(seatId);
                venueRow.add(seatId,seat);
            }
        }
    }

    public Row getRow(int rowNumber) {
        return rows.get(rowNumber);
    }

    public void print() {
        rows.forEach(Row::print);
    }

    static Venue initialiseSeatingPlan(Customer customer) {
        String[][] seatingPlan = {
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"},
                {"A", "B", "C", "D", "E", "F", "G"}
        };

        Venue venue = new Venue(seatingPlan);
        seatingPlanMenu(customer, venue);
        return venue;
    }
}
