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
        Ride[] rides = {new Ride(2.0, 5,1,RideType.PREMIUM),
                                            new Ride(0.1,1,1,RideType.NORMAL)
        };
        double fare = invoiceGenrator.totalFare(rides);
        Assert.assertEquals(30,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5,1,RideType.NORMAL),
                new Ride(0.1,1,1,RideType.NORMAL)
        };
        InvoiceSummary invoiceSummary =  invoiceGenrator.totalFares(rides);
        InvoiceSummary invoiceSummary1 = new InvoiceSummary(2, 30.0,1);
        Assert.assertEquals(invoiceSummary1, invoiceSummary);
    }

    @Test
    public void givenUserId_getsListOfRides_ShouldReturnInvoice() {
        Ride[] rides = {new Ride(2.0, 5,1,RideType.PREMIUM),new Ride(4,6,2,RideType.PREMIUM)
        };
       RideRepositoryImpl rideRepository = new RideRepositoryImpl();
        InvoiceSummary invoiceSummary =  invoiceGenrator.totalFares(rides);
        Assert.assertEquals(71, invoiceSummary.totalFare,0.0);
        Assert.assertEquals(1, invoiceSummary.userId,0.0);
    }
    /**
     * premium rides and normal rides.
     */

    @Test
    public void givenPremiumAndNormalRideForUserId_ShouldReturnInvoiceSummary()  {

        String[] userId = {"user1", "user2", "user3"};
        Ride[][] rides = {{new Ride(5.0, 12, 1,RideType.PREMIUM), new Ride(2.5, 6,1, RideType.NORMAL)},
                {new Ride(3.0, 5, 1,RideType.PREMIUM), new Ride(0.01, 1, 1,RideType.PREMIUM)},
                {new Ride(10.0, 15,1, RideType.NORMAL), new Ride(2, 30,1, RideType.PREMIUM)}};
        invoiceGenrator.addRideToRepository(userId, rides);
        double summary = invoiceGenrator.invoiceForUser(userId[1]);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(rides[1].length, 75.0,1);
        Assert.assertEquals(expectedInvoiceSummary, summary);

    }
}
