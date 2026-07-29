package demo;

import datastructures.CustomHashTable;
import datastructures.CustomHashSet;
import Users.Passenger;
import models.Booking;
import models.Seat;
import java.util.Date;

public class Member6_Demo {
    public static void main(String[] args) {
        System.out.println("=== MEMBER 6: HASH TABLE & SET ADT DEMO ===\n");

        // ---------- PART 1: HASH TABLE ----------
        // Key: Integer (bookingId), Value: Booking object
        CustomHashTable<Integer, Booking> bookingTable = new CustomHashTable<>(8);

        Passenger p1 = new Passenger(101, "Alice Smith", "alice@email.com", "0771234567");
        Passenger p2 = new Passenger(102, "Bob Jones", "bob@email.com", "0777654321");
        Passenger p3 = new Passenger(103, "Charlie Brown", "charlie@email.com", "0711122334");

        // Create Seat objects matching your Seat model: (seatId, seatNumber, status, type)
        Seat seat1 = new Seat(1, 5, "Available", "Window");
        Seat seat2 = new Seat(2, 6, "Available", "Aisle");
        Seat seat3 = new Seat(3, 1, "Available", "VIP");

        // Reserve seats using Seat class logic
        seat1.reserve(); // Changes status to "Reserved"
        seat2.reserve();
        seat3.reserve();

        // Create Bookings matching UML model: (int bookingId, Date bookingDate, String status, Seat seat)
        Booking b1 = new Booking(1001, new Date(), "CONFIRMED", seat1);
        Booking b2 = new Booking(1002, new Date(), "CONFIRMED", seat2);
        Booking b3 = new Booking(1003, new Date(), "CONFIRMED", seat3);

        // Put into CustomHashTable
        bookingTable.put(b1.getBookingId(), b1);
        bookingTable.put(b2.getBookingId(), b2);
        bookingTable.put(b3.getBookingId(), b3);

        System.out.println("--- Fast Lookup by Booking ID ---");
        int searchBookingId = 1002;
        Booking found = bookingTable.get(searchBookingId);
        System.out.println("Searching for Booking #" + searchBookingId + " -> \n  " +
                (found != null ? found : "Not found"));

        System.out.println("\n--- Testing Booking Cancellation & Seat Release ---");
        if (found != null) {
            found.cancelBooking(); // Cancels the booking
            found.getSeat().release(); // Releases seat back to "Available" using your Seat method
            System.out.println("Updated Seat Status: " + found.getSeat().getStatus());
        }

        System.out.println("\n--- Bucket Distribution (shows collision handling) ---");
        bookingTable.printBucketDistribution();

        System.out.println("\nTotal bookings stored: " + bookingTable.getSize());

        // ---------- PART 2: SET ADT ----------
        // Prevents duplicate seat bookings using unique keys
        System.out.println("\n--- Set ADT: Preventing Duplicate Seat Booking ---");
        CustomHashSet<String> bookedSeats = new CustomHashSet<>();

        // Generate unique keys using bus identifier and seat number
        String seatKey1 = "BUS12_SEAT_" + seat1.getSeatNumber();
        String seatKey2 = "BUS12_SEAT_" + seat2.getSeatNumber();
        String duplicateSeatKey = "BUS12_SEAT_" + seat1.getSeatNumber(); // Seat 5 again

        System.out.println("Booking " + seatKey1 + " -> " +
                (bookedSeats.add(seatKey1) ? "SUCCESS" : "REJECTED (already booked)"));
        System.out.println("Booking " + seatKey2 + " -> " +
                (bookedSeats.add(seatKey2) ? "SUCCESS" : "REJECTED (already booked)"));
        System.out.println("Booking " + duplicateSeatKey + " again -> " +
                (bookedSeats.add(duplicateSeatKey) ? "SUCCESS" : "REJECTED (already booked)"));

        System.out.println("\nTotal unique seats booked: " + bookedSeats.size());
    }
}
