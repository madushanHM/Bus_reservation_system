package demo;

import datastructures.CustomHashTable;
import datastructures.CustomHashSet;
import models.Passenger;
import models.Booking;

public class Member6_Demo {
    public static void main(String[] args) {
        System.out.println("=== MEMBER 6: HASH TABLE & SET ADT DEMO ===\n");

        // ---------- PART 1: HASH TABLE ----------
        // Stores bookings keyed by Ticket ID for fast lookup
        CustomHashTable<String, Booking> bookingTable = new CustomHashTable<>(8);

        Passenger p1 = new Passenger(101, "Alice Smith", "alice@email.com", "0771234567");
        Passenger p2 = new Passenger(102, "Bob Jones", "bob@email.com", "0777654321");
        Passenger p3 = new Passenger(103, "Charlie Brown", "charlie@email.com", "0711122334");

        bookingTable.put("TCK1001", new Booking("TCK1001", p1, "BUS12", 5));
        bookingTable.put("TCK1002", new Booking("TCK1002", p2, "BUS12", 6));
        bookingTable.put("TCK1003", new Booking("TCK1003", p3, "BUS07", 1));

        System.out.println("--- Fast Lookup by Ticket ID ---");
        String searchTicket = "TCK1002";
        Booking found = bookingTable.get(searchTicket);
        System.out.println("Searching for " + searchTicket + " -> " +
                (found != null ? found : "Not found"));

        System.out.println("\n--- Bucket Distribution (shows collision handling) ---");
        bookingTable.printBucketDistribution();

        System.out.println("\nTotal bookings stored: " + bookingTable.getSize());

        // ---------- PART 2: SET ADT ----------
        // Prevents the same seat on the same bus being booked twice
        System.out.println("\n--- Set ADT: Preventing Duplicate Seat Booking ---");
        CustomHashSet<String> bookedSeats = new CustomHashSet<>();

        String seat1 = "BUS12_SEAT5";
        String seat2 = "BUS12_SEAT6";
        String duplicateSeat = "BUS12_SEAT5"; // same as seat1 - should be rejected

        System.out.println("Booking " + seat1 + " -> " +
                (bookedSeats.add(seat1) ? "SUCCESS" : "REJECTED (already booked)"));
        System.out.println("Booking " + seat2 + " -> " +
                (bookedSeats.add(seat2) ? "SUCCESS" : "REJECTED (already booked)"));
        System.out.println("Booking " + duplicateSeat + " again -> " +
                (bookedSeats.add(duplicateSeat) ? "SUCCESS" : "REJECTED (already booked)"));

        System.out.println("\nTotal unique seats booked: " + bookedSeats.size());
    }
}
