package com.travcomp.model;

public class Trip {
    private int id;
    private User driver;
    private String startLocation;
    private String endLocation;
    private String dateTime;
    private int carNumber;
    private int availableSeats;
    private int cost;

    public Trip(int id, User driver, String startLocation,
                String endLocation, String dateTime,
                int carNumber, int availableSeats, int cost) {
        this.id = id;
        this.driver = driver;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.dateTime = dateTime;
        this.carNumber = carNumber;
        this.availableSeats = availableSeats;
        this.cost = cost;
    }

    public Trip(User driver, String startLocation,
                String endLocation, String dateTime,
                int carNumber, int availableSeats, int cost) {
        this.driver = driver;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.dateTime = dateTime;
        this.carNumber = carNumber;
        this.availableSeats = availableSeats;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

