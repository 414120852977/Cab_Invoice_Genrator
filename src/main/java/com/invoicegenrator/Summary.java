package com.invoicegenrator;

import java.util.Objects;

public class Summary {
    public final int noOfRides;
    public final double TotalFare;
    public final double averageFare;

    public Summary(int noOfRides, double TotalFare) {
        this.noOfRides = noOfRides;
        this.TotalFare = TotalFare;
        this.averageFare = this.TotalFare/this.noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return noOfRides == summary.noOfRides && Double.compare(summary.TotalFare, TotalFare) == 0 && Double.compare(summary.averageFare, averageFare) == 0;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "noOfRides=" + noOfRides +
                ", TotalFare=" + TotalFare +
                ", averageFare=" + averageFare +
                '}';
    }
}
