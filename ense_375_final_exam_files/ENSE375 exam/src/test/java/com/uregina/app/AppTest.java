package com.uregina.app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import com.uregina.exceptions.InvalidTimeException;
import com.uregina.exceptions.MoreThanOneDayException;
import com.uregina.exceptions.NegativeTimeException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testcase_withoutvisa_true()
            throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException {

        App app = new App();
        ArrayList<Flight> ticket = new ArrayList<Flight>();
        String airport_code_of_departure = "CPH";
        String airport_code_of_arrival = "FRA";
        Date date_of_departure = app.parseDate("01/01/2021");
        Time12 time_of_departure = app.parseTime("11:00 am");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival, new DateTime(date_of_departure, time_of_departure),
                new DateTime(date_of_arrival, time_of_arrival)));
        int maxFlightsCount = 10000;
        int maxFlightTime = 10000;
        int maxLayoverTime = 10000;
        boolean hasSchengenVisa = false;
        Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa);
        assertTrue(true);
    }

    @Test
    public void testcase_withvisa_true() throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException {

        App app = new App();
        ArrayList<Flight> ticket = new ArrayList<Flight>();
        String airport_code_of_departure = "CPH";
        String airport_code_of_arrival = "FRA";
        Date date_of_departure = app.parseDate("01/01/2021");
        Time12 time_of_departure = app.parseTime("11:00 am");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival, new DateTime(date_of_departure, time_of_departure),
                new DateTime(date_of_arrival, time_of_arrival)));
        int maxFlightsCount = 10000;
        int maxFlightTime = 10000;
        int maxLayoverTime = 10000;
        boolean hasSchengenVisa = true;
        Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa);
        assertTrue(true);
    }

    @Test
    public void testcase_1code_not_schengen()
            throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException {

        App app = new App();
        ArrayList<Flight> ticket = new ArrayList<Flight>();
        String airport_code_of_departure = "CPH";
        String airport_code_of_arrival = "YQR";
        Date date_of_departure = app.parseDate("01/01/2021");
        Time12 time_of_departure = app.parseTime("11:00 am");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival, new DateTime(date_of_departure, time_of_departure),
                new DateTime(date_of_arrival, time_of_arrival)));
        int maxFlightsCount = 10000;
        int maxFlightTime = 10000;
        int maxLayoverTime = 10000;
        boolean hasSchengenVisa = false;
        Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa);
        assertTrue(true);
    }

    @Test
    public void testcase_bothcode_not_schengen()
            throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException {

        App app = new App();
        ArrayList<Flight> ticket = new ArrayList<Flight>();
        String airport_code_of_departure = "AMD";
        String airport_code_of_arrival = "YQR";
        Date date_of_departure = app.parseDate("01/01/2021");
        Time12 time_of_departure = app.parseTime("11:00 am");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival, new DateTime(date_of_departure, time_of_departure),
                new DateTime(date_of_arrival, time_of_arrival)));
        int maxFlightsCount = 10000;
        int maxFlightTime = 10000;
        int maxLayoverTime = 10000;
        boolean hasSchengenVisa = false;
        Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa);
        assertTrue(true);
    }

    @Test
    public void testcase_code_notIATA() throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException {

        App app = new App();
        ArrayList<Flight> ticket = new ArrayList<Flight>();
        String airport_code_of_departure = "CPHR";
        String airport_code_of_arrival = "FRA";
        Date date_of_departure = app.parseDate("01/01/2021");
        Time12 time_of_departure = app.parseTime("11:00 am");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival, new DateTime(date_of_departure, time_of_departure),
                new DateTime(date_of_arrival, time_of_arrival)));
        int maxFlightsCount = 10000;
        int maxFlightTime = 10000;
        int maxLayoverTime = 10000;
        boolean hasSchengenVisa = false;
        Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa);
        assertFalse(false);
    }

    @Test
    public void testcase_invalid_date() throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException {

        App app = new App();
        ArrayList<Flight> ticket = new ArrayList<Flight>();
        String airport_code_of_departure = "CPH";
        String airport_code_of_arrival = "FRA";
        Date date_of_departure = app.parseDate("012021");
        Time12 time_of_departure = app.parseTime("11:00 am");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival, new DateTime(date_of_departure, time_of_departure),
                new DateTime(date_of_arrival, time_of_arrival)));
        int maxFlightsCount = 10000;
        int maxFlightTime = 10000;
        int maxLayoverTime = 10000;
        boolean hasSchengenVisa = false;
        Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa);
        assertFalse(false);
    }

    @Test
    public void testcase_invalid_time() throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException {

        App app = new App();
        ArrayList<Flight> ticket = new ArrayList<Flight>();
        String airport_code_of_departure = "CPH";
        String airport_code_of_arrival = "FRA";
        Date date_of_departure = app.parseDate("01/01/2021");
        Time12 time_of_departure = app.parseTime("25:00");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival, new DateTime(date_of_departure, time_of_departure),
                new DateTime(date_of_arrival, time_of_arrival)));
        int maxFlightsCount = 10000;
        int maxFlightTime = 10000;
        int maxLayoverTime = 10000;
        boolean hasSchengenVisa = false;
        Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa);
        assertFalse(false);
    }

    @Test
    public void testcase_invalidcode_numbers() throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException{

        App app = new App();
        ArrayList<Flight> ticket= new ArrayList<Flight>();
        String airport_code_of_departure = "123";
        String airport_code_of_arrival = "456";
        Date date_of_departure = app.parseDate("01/01/2021");
        Time12 time_of_departure= app.parseTime("11:00 am");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival,new DateTime(date_of_departure,time_of_departure),new DateTime(date_of_arrival,time_of_arrival)));
        int maxFlightsCount=10000;
		int maxFlightTime=10000;
		int maxLayoverTime=10000;
        boolean hasSchengenVisa = false;
        Ticket.checkTicket(ticket,maxFlightsCount,maxFlightTime,maxLayoverTime,hasSchengenVisa);
        assertFalse( false );
    }

    @Test
    public void testcase_exceedingflighttime_and_flightcount() throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException{

        App app = new App();
        ArrayList<Flight> ticket= new ArrayList<Flight>();
        String airport_code_of_departure = "123";
        String airport_code_of_arrival = "456";
        Date date_of_departure = app.parseDate("01/01/2021");
        Time12 time_of_departure= app.parseTime("11:00 am");
        Date date_of_arrival = app.parseDate("01/02/2021");
        Time12 time_of_arrival = app.parseTime("10:00 pm");
        ticket.add(new Flight(airport_code_of_departure, airport_code_of_arrival,new DateTime(date_of_departure,time_of_departure),new DateTime(date_of_arrival,time_of_arrival)));
        int maxFlightsCount=0;
		int maxFlightTime=0;
		int maxLayoverTime=0;
        boolean hasSchengenVisa = false;
        Ticket.checkTicket(ticket,maxFlightsCount,maxFlightTime,maxLayoverTime,hasSchengenVisa);
        assertFalse( false );
    }
}
