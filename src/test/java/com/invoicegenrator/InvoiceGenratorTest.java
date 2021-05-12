package com.invoicegenrator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGenratorTest {
    InvoiceGenrator invoiceGenrator = null;

    @Before
    public void setUp() throws Exception {
        invoiceGenrator = new InvoiceGenrator();
    }

    /**
     * calculate total fare ......
     */
    @Test
    public void givenDistanceAndTime_ShouldReturn_TotalFare() {
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
        int time = 1;
        double distance = 0.1;
        double fare  =  invoiceGenrator.totalFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    /**
     * invoice genrator should now take in multiple rides,and calculate aggregate total for all..
     */
    @Test
    public void givenMultipleRides_ShouldReturnTotalAggregate() {
        InvoiceSummary[] invoiceSummarys = {new InvoiceSummary(2.0, 5),
                                            new InvoiceSummary(0.1,1)
        };
        double fare = invoiceGenrator.totalFare(invoiceSummarys);
        Assert.assertEquals(30,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenrator invoiceGenrator = new InvoiceGenrator();
        InvoiceSummary[] invoiceSummarys = {new InvoiceSummary(2.0, 5),
                new InvoiceSummary(0.1,1)
        };
        Summary  summary =  invoiceGenrator.totalFares(invoiceSummarys);
        Summary summary1 = new Summary(2, 30.0);
        Assert.assertEquals(summary1,summary);
    }
}
