package com.company.ots;

import java.util.HashMap;
import java.util.Map;

public class Row {
    private Map<String, Seat> seats = new HashMap<>();

    public void add(String seatLetter, Seat seat) {
        seats.put(seatLetter,seat);
    }

    public Seat getSeat(String seatLetter) {
        return seats.get(seatLetter);
    }

    public static void print(Integer rowNumber, Row row) {
        System.out.println(rowNumber);

        row.print();
    }

    private void print() {
        seats.forEach(Seat::print);
    }
}
