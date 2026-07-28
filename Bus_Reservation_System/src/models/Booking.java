package models;

public class Booking {
    private String ticketId;   // Unique key used for Hash Table lookup
    private Passenger passenger;
    private String busId;
    private int seatNumber;

    public Booking(String ticketId, Passenger passenger, String busId, int seatNumber) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.busId = busId;
        this.seatNumber = seatNumber;
    }

    public String getTicketId() { return ticketId; }
    public Passenger getPassenger() { return passenger; }
    public String getBusId() { return busId; }
    public int getSeatNumber() { return seatNumber; }

    @Override
    public String toString() {
        return "Booking{TicketID='" + ticketId + "', Passenger=" + passenger.getName() +
                ", Bus='" + busId + "', Seat=" + seatNumber + '}';
    }
}
