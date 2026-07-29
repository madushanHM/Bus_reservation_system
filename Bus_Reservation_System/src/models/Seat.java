package models;

public class Seat {
    private int seatId;
    private int seatNumber;
    private String status;
    private String type;

    public Seat(int seatId, int seatNumber, String status, String type) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.status = status;
        this.type = type;
    }

    public boolean reserve() {
        if ("Available".equalsIgnoreCase(this.status)) {
            this.status = "Reserved";
            return true;
        }
        return false;
    }

    public void release() {
        this.status = "Available";
    }

    // Getters and Setters
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "ID=" + seatId +
                ", No=" + seatNumber +
                ", Status='" + status + '\'' +
                ", Type='" + type + '\'' +
                '}';
    }
}