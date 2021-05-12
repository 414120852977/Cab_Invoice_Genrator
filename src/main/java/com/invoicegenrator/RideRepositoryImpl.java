package com.invoicegenrator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RideRepositoryImpl implements  RideRepository {
    List<Ride>  rides = new ArrayList<>();
    @Override
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    @Override
    public List<Ride> getRide(int userId) {
        return rides.stream().filter(ride -> ride.userId == userId).collect(Collectors.toList());
    }
}
