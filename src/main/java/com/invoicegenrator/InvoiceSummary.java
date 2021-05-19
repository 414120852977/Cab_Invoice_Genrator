package com.invoicegenrator;

import java.util.Objects;

public class InvoiceSummary {
    public final int noOfRides;
    public final double totalFare;
    public final int userId;
    public final double averageFare;

    public InvoiceSummary(int noOfRides, double totalFare, int userId) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.userId = userId;
        this.averageFare = this.totalFare/this.noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary invoiceSummary = (InvoiceSummary) o;
        return noOfRides == invoiceSummary.noOfRides && Double.compare(invoiceSummary.totalFare, totalFare) == 0 && userId == invoiceSummary.userId && Double.compare(invoiceSummary.averageFare, averageFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noOfRides, totalFare, userId, averageFare);
    }

    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "noOfRides=" + noOfRides +
                ", totalFare=" + totalFare +
                ", userId=" + userId +
                ", averageFare=" + averageFare +
                '}';
    }
}
