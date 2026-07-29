package demo;

import datastructures.CustomLinkedList;
import Users.Passenger;

public class Member1_Demo {
    public static void main(String[] args) {
        System.out.println("=== MEMBER 1: LINKED LIST & LINEAR SEARCH DEMO ===\n");

        CustomLinkedList<Passenger> passengerList = new CustomLinkedList<>();

        // 1. Adding Passengers to Linked List
        passengerList.add(new Passenger(101, "Alice Smith", "alice@email.com", "0771234567"));
        passengerList.add(new Passenger(102, "Bob Jones", "bob@email.com", "0777654321"));
        passengerList.add(new Passenger(103, "Charlie Brown", "charlie@email.com", "0711122334"));

        System.out.println("--- All Passengers in Linked List ---");
        passengerList.display();

        // 2. Performing Linear Search by Passenger ID
        int searchId = 102;
        System.out.println("\n--- Performing Linear Search for Passenger ID: " + searchId + " ---");
        Passenger found = passengerList.linearSearch(p -> p.getUserId() == searchId);

        if (found != null) {
            System.out.println("Result: Found -> " + found);
        } else {
            System.out.println("Result: Passenger with ID " + searchId + " not found.");
        }
    }
}
