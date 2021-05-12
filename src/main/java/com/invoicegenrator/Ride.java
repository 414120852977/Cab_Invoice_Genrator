package com.invoicegenrator;

public class Ride {
    public final double distance;
    public final int time;
    public final int userId;

    public Ride(double distance, int time, int userId) {
        this.distance = distance;
        this.time = time;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "distance=" + distance +
                ", time=" + time +
                ", userId=" + userId +
                '}';
    }
}
