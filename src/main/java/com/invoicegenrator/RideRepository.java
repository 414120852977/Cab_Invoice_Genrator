package com.invoicegenrator;

import java.util.List;

public interface RideRepository {
    public void addRide(Ride ride);
    public List<Ride> getRide(int userId);
}

