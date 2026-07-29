package models;

import datastructures.CustomLinkedList;

public class Bus {
    private int busId;
    private String busNumber;
    private int capacity;
    private String status;
    private String type;
    private CustomLinkedList<Seat> seats;

    public Bus(int busId, String busNumber, int capacity, String status, String type) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.status = status;
        this.type = type;
        this.seats = new CustomLinkedList<>();
    }

    // Admin calls this method to add each declared seat
    public void addSeat(Seat seat) {
        if (seats.getSize()< capacity) {
            this.seats.add(seat);
        }
    }

    public CustomLinkedList<Seat> getSeats() {
        return seats;
    }
}