package com.company.ots;

public class Seat {
    private SeatState state;
    private String id;

    public Seat(String seatId) {
        this.id = seatId;
        this.state = SeatState.AVAILABLE;
    }

    public void setState(SeatState seatState) {
        this.state = seatState;
    }

    public static void print(String seatId, Seat seat) {
        seat.print();
    }

    private void print() {
        System.out.println(id + " (" + state + ") ");
    }
}


