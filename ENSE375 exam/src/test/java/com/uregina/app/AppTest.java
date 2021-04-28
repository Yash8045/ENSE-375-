package com.uregina.app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.uregina.exceptions.MoreThanOneDayException;
import com.uregina.exceptions.NegativeTimeException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     *
     */
    private static final boolean BOOLEAN = false;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void generalFlightInformationTrue() throws MoreThanOneDayException, NegativeTimeException{

        App app = new App();
        ArrayList<Flight> ticket= new ArrayList<Flight>();
        String depatureAirport = "VIE";
        String arrivalAirport = "BRU";
        Date depatureDate = app.parseDate("01/01/2021");
        //hh:mm am/pm
        Time12 depatureTime= app.parseTime("08:00 am");
        Date arrivalDate = app.parseDate("01/02/2021");
        Time12 arrivalTime = app.parseTime("09:00 pm");
        ticket.add(new Flight(depatureAirport, arrivalAirport,new DateTime(depatureDate,depatureTime),new DateTime(arrivalDate,arrivalTime)));
        int maxFlightsCount=10000;
		int maxFlightTime=10000;
		int maxLayoverTime=10000;
        boolean hasSchengenVisa = BOOLEAN;
        Ticket.checkTicket(ticket,maxFlightsCount,maxFlightTime,maxLayoverTime,hasSchengenVisa);
        assertTrue( true );
    }
}
