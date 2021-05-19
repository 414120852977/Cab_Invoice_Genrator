package com.invoicegenrator;

import java.util.stream.IntStream;

public class InvoiceGenrator {
    RideRepositoryImpl rideRepository = new RideRepositoryImpl();

    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5.0;
    private static final double MINIMUM_COST_PER_KM_PREMIUM = 15.0;
    private static final int COST_PER_TIME_PREMIUM = 2;
    private static final double MINIMUM_FARE_PREMIUM = 20.0;


    public double totalFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        } else {
            return totalFare;
        }
    }

    public double totalFare(Ride[] rides) {
        double totalFares = 0;
        for (Ride ride : rides) {
            totalFares += this.totalFare(ride.distance, ride.time);
        }
        return totalFares;

    }

    public InvoiceSummary totalFares(Ride[] rides) {
        double totalFares = 0;
        for (Ride ride : rides) {
            totalFares += this.totalFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFares, 1);
    }

    public void addingRide() {

    }

    public double invoiceForUser(String userId) {
        return totalFare(rideRepository.getRidesForUser(userId));
    }

    public void addRideToRepository(String[] userId, Ride[][] rides) {
        RideRepositoryImpl rideRepository = new RideRepositoryImpl();
        IntStream.range(0, userId.length).forEach(i -> {
            try {
                rideRepository.addRideForUser(userId[i], rides[i]);
            } catch (InvoiceGeneratorException e) {
                e.printStackTrace();
            }
        });
    }
}

