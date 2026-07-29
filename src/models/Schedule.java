package models;

import java.sql.Time;
import java.util.Date;

public class Schedule {
    private int scheduleId;
    private Time departureTime;
    private Time arrivalTime;
    private Date travelDate;

    public Schedule(int scheduleId, Time departureTime, Time arrivalTime, Date travelDate) {
        this.scheduleId = scheduleId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.travelDate = travelDate;
    }

    public void updateSchedule(Time departureTime, Time arrivalTime, Date travelDate) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.travelDate = travelDate;
    }

    public void cancelSchedule() {
        // Logic to cancel schedule
    }

    // Getters and Setters
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }
}