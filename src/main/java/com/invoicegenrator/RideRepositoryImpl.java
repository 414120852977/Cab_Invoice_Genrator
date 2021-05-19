package com.invoicegenrator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepositoryImpl  {

    Map<String, Ride[]> userRides = new HashMap<>();

    public void addRideForUser(String userId, Ride[] rides) throws InvoiceGeneratorException {
        if (userRides.containsKey(userId))
            throw new InvoiceGeneratorException(InvoiceGeneratorException.ExceptionType.USER_ALREADY_EXISTS,
                    "User ID Already Exists!!!");
        else
            userRides.put(userId, rides);
    }


    public Ride[] getRidesForUser(String userId) {
        return userRides.get(userId);
    }
}