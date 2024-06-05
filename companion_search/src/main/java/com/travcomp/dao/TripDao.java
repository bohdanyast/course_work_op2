package com.travcomp.dao;

import java.util.Collection;
import java.util.List;

import com.travcomp.model.Trip;

public interface TripDao {
    void create(Trip trip);

    Trip findById(Integer id);

    Collection<Trip> findAll();

    List<Trip> searchTrips(String startLocation, String endLocation);

    void update(Trip trip);

    void deleteById(Integer id);
}
