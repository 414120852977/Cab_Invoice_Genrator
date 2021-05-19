package com.invoicegenrator;

public class Ride {

    private final RideType ride_type;
    public  double distance;
    public  int time;
    public  int userId;

    public Ride(double distance, int time, int userId,RideType ride_type) {
        this.distance = distance;
        this.time = time;
        this.userId = userId;
        this.ride_type = ride_type;
    }


    @Override
    public String toString() {
        return "Ride{" +
                "ride_type=" + ride_type +
                ", distance=" + distance +
                ", time=" + time +
                ", userId=" + userId +
                '}';
    }

    public Ride(RideType ride_type) {
        this.ride_type = ride_type;
    }
}
