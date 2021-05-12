package com.invoicegenrator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGenratorTest {
    /**
     * calculate total fare ......
     */
    @Test
    public void givenDistanceAndTime_ShouldReturn_TotalFare() {
       InvoiceGenrator invoiceGenrator = new InvoiceGenrator();
       int time = 5;
       double distance = 2.0;
      double fare  =  invoiceGenrator.totalFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    /**
     * given less distance and time should return mimimum fare.....
     */
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        InvoiceGenrator invoiceGenrator = new InvoiceGenrator();
        int time = 1;
        double distance = 0.1;
        double fare  =  invoiceGenrator.totalFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }
}
