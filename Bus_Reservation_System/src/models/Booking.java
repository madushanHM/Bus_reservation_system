package models;

import java.util.Date;

public class Booking {
    // Private attributes matching UML class diagram
    private int bookingId;
    private Date bookingDate;
    private String status;
    private Seat seat;

    // Constructor
    public Booking(int bookingId, Date bookingDate, String status, Seat seat) {
        this.bookingId = bookingId;
        this.bookingDate = bookingDate;
        this.status = status;
        this.seat = seat;
    }

    // UML Methods
    public boolean createBooking() {
        // Business logic to create/confirm a booking
        this.status = "CONFIRMED";
        System.out.println("Booking #" + bookingId + " created successfully.");
        return true;
    }

    public boolean cancelBooking() {
        // Business logic to cancel a booking
        this.status = "CANCELLED";
        System.out.println("Booking #" + bookingId + " has been cancelled.");
        return true;
    }

    // Standard Getters & Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                ", seat=" + seat +
                '}';
    }
}
