package com.travcomp.dao;

import com.travcomp.model.Trip;
import com.travcomp.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTripDao implements TripDao {
    private List<Trip> trips = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void create(Trip trip) {
        trip.setId(idCounter++);
        trips.add(trip);
    }

    @Override
    public Trip findById(Integer id) {
        return trips.stream().filter(trip -> trip.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Trip> findAll() {
        return new ArrayList<>(trips);
    }

    @Override
    public void update(Trip trip) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getId() == trip.getId()) {
                trips.set(i, trip);
                return;
            }
        }
    }

    @Override
    public void deleteById(Integer id) {
        trips.removeIf(trip -> trip.getId() == id);
    }

    @Override
    public List<Trip> searchTrips(String startLocation, String endLocation) {
        return trips.stream()
                .filter(trip -> (startLocation == null || trip.getStartLocation().equalsIgnoreCase(startLocation)) ||
                        (endLocation == null || trip.getEndLocation().equalsIgnoreCase(endLocation)))
                .collect(Collectors.toList());
    }

    public List<Trip> findTripsByUser(User user) {
        List<Trip> userTrips = new ArrayList<>();
        for (Trip trip : trips) {
            if (trip.getDriver().equals(user)) {
                userTrips.add(trip);
            }
        }
        return userTrips;
    }
}
