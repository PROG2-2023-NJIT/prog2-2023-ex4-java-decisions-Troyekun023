package prog2.exercise4.flight.booking.system;

import java.time.LocalDate;
import java.util.Scanner;

public class Main 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your full name: ");
        String passengerFullName = input.nextLine();
        System.out.println("Please enter your year of departure: ");
        int dYear = input.nextInt();
        System.out.println("Please enter your month of departure: ");
        int dMonth = input.nextInt();
        System.out.println("Please enter your day of departure: ");
        int dDay = input.nextInt();
        System.out.println("Please enter your year of return: ");
        int rYear = input.nextInt();
        System.out.println("Please enter your month of return: ");
        int rMonth = input.nextInt();
        System.out.println("Please enter your day of return: ");
        int rDay = input.nextInt();
        System.out.println("Please enter how many children tickets do you need: ");
        int childPassengers = input.nextInt();
        System.out.println("Please enter how many adult tickets do you need: ");
        int adultPassengers = input.nextInt();




        LocalDate departureDate =  LocalDate.of(dYear, dMonth, dDay);
        LocalDate returnDate =  LocalDate.of(rYear, rMonth, rDay);
        input.close();

        FlightBooking family1 = new FlightBooking(passengerFullName, departureDate, returnDate, childPassengers, adultPassengers);


        family1.setTripSource("1");
        family1.setTripDestination("1", "2");
        family1.setReturnDate(returnDate);
        family1.setTripType("2");
        family1.setBookingClass("1");

        family1.setDepartingTicketPrice(2, 5);
        family1.setReturnTicketPrice();

        family1.setTotalTicketPrice();

        System.out.println(family1.StringOption1());
        
    }
}
