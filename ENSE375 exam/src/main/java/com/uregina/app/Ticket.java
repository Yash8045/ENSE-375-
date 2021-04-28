package com.uregina.app;

import com.uregina.exceptions.*;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class Ticket, a List of Flights in ordered sequences
 *
 */
public class Ticket
{
	
	private static final String [] SchengenAirportsCode = new String[] { "VIE","BRU","PRG","CPH","TLL","HEL","CDG","FRA","MUC","ATH","BUD","KEF","CIA","RIX","VNO","LUX","MLA","AMS","OSL","WAW","LIS","LJU","KSC","MAD","ARN","BRN"};
	//private static final ArrayList SchengenAirportsCode = (ArrayList) Arrays.asList("VIE","BRU","PRG","CPH","TLL","HEL","CDG","FRA","MUC","ATH","BUD","KEF","CIA","RIX","VNO","LUX","MLA","AMS","OSL","WAW","LIS","LJU","KSC","MAD","ARN","BRN"); 
	/**
	 * The function checks the validaity of a ticket
	 * It checks
	 *		1. airports code are in IATA format (any three uppercases letters)
	 *		2. maximum flights Count <= number of flights in the ticket
	 *		3. maximum flight time <= Total flight times ( sum of flight time of each flight)
	 *		4. maximum layover time <= Total layover times ( sum of layover time between each consequative flight)
	 *		5. no flight between two airports in the Schengen area unless the passenger has a valid SchengenVisa
	 *		6. no cyclic trip
	 *		7. The sequence of flights in correct ( the arrival airport of a flight is the departure airport of the next flight)
	 * 		8. any other logical constraints 
	 * @param	ticket				List of ordered sequences of flights
	 * @param	maxFlightsCount		Maximum number of flights in the ticket
	 * @param	maxFlightTime		Maximum allowable total flight times in minutes
	 * @param	maxLayoverTime		Maximum allowable total layover times in minutes
	 * @param	hasSchengenVisa		to indicate if the passenger has a valid Schengen Visa or not
	 * @return	true if the ticket is valid, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	 * 		(class: Flight , method: calculateFlightTime)
	 * 		(class: Flight , method: calculateLayoverTime)
	 * 		(class: ticket , method: hasCyclicTrip)
	 * @throws NegativeTimeException
	 * @throws MoreThanOneDayException
	*/
	private static int index = 0;
	public static boolean checkTicket( ArrayList<Flight> ticket, int maxFlightsCount, int maxFlightTime, int maxLayoverTime, boolean hasSchengenVisa) throws MoreThanOneDayException, NegativeTimeException, InvalidTimeException
	{
		//Todo: add your code here
		int size = ticket.size();
		Boolean flag = false;
		int time = Flight.calculateFlightTime();
		//int layOver = Flight.calculateLayoverTime(firstFlight, nextFlight);
		int ArrivalIATA = Flight.getArrivalAirport().length();
		int DepartureIATA = Flight.getDepatureAirport().length();

		if (size <= maxFlightsCount && time <= maxFlightTime && ArrivalIATA == 3 && DepartureIATA == 3)
		{
			for(index = 0; index < SchengenAirportsCode.length; index++)
			{
				for (int j = 0; j < SchengenAirportsCode.length; j++)
				{
					if ((Flight.getDepatureAirport()).contains(SchengenAirportsCode[j]) && (Flight.getArrivalAirport()).contains(SchengenAirportsCode[index]))
					{
						System.out.println("Checked");
						if (hasSchengenVisa == true)
						{
							System.out.println("Has visa");
							flag = true;	
							break;
						}
						else{
							System.out.println("No visa");
							flag = false;
							break;
						}
					}
					else
					{
						flag = true;
					}
				}
			}
		}

		return flag;
	}
		/**
	 * The function checks if the ticket has a cyclic trip
	 * (that is, no passenger can arrive at the same airport more than once within the same ticket)
	 * @param	ticket				List of ordered sequences of flights
	 * @return	true if the ticket has a cyclic trip, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	*/
	public static boolean hasCyclicTrip(ArrayList<Flight> ticket)
	{
		//Todo : add your code here
		

		//Todo : end of your code
		return false;
	}
}