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

    public double totalFare(InvoiceSummary[] invoiceSummarys) {
        double totalFares = 0;
        for (InvoiceSummary invoiceSummary : invoiceSummarys) {
            totalFares += this.totalFare(invoiceSummary.distance, invoiceSummary.time);
        }
        return totalFares;
    }
}
