package com.invoicegenrator;

public class InvoiceGenrator {

    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5.0;

    public double totalFare(double distance, int time) {
        double totalFare =  distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        if(totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }else {
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

    public Summary totalFares(Ride[] rides) {
        double totalFares = 0;
        for (Ride ride : rides) {
            totalFares += this.totalFare(ride.distance, ride.time);
        }
        return new Summary(rides.length,totalFares);
    }
    public  void addingRide() {

    }

    public int bonusRide(int distance , int time) {
        int bonus = 0;
            double totalFare =  distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
        if(totalFare <= MINIMUM_FARE) {
            bonus = 0;
        }
        else if (totalFare > MINIMUM_FARE) {
            bonus = 15;
        }
        return bonus;
    }
}
