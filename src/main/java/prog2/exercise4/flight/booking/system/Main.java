package prog2.exercise4.flight.booking.system;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws ParseException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your full name");
        String name = scanner.next();

        System.out.println("Please select the date of departure(like 2023-03-07)");
        String departure1 = scanner.next();
        LocalDate departure = LocalDate.parse(departure1);

        System.out.println("Please select the date of return(like 2023-03-07)");
        String return2 = scanner.next();
        LocalDate return1 = LocalDate.parse(return2);

        System.out.println("Please enter the number of children");
        int child = scanner.nextInt();

        System.out.println("Please enter the number of adults");
        int adults = scanner.nextInt();

        FlightBooking flightbooking = new FlightBooking(name,departure,return1,child,adults);
        System.out.println("Please choose the class of travel (Enter 1 for First, 2 for Business, 3 for Economy):");
        String choice1 = scanner.next();
        flightbooking.setBookingClass(choice1);

        System.out.println("Please choose the trip type(Enter 1 for One way, 2 for Return)");
        String choice2 = scanner.next();
        flightbooking.setTripType(choice2);

        System.out.println("Please choose the trip source(Enter 1 for Nanjing, 2 for Beijing, 3 for Oulu, 4 for Helsinki) ");
        String source = scanner.next();
        flightbooking.setTripSource(source);

        System.out.println("Please choose the trip destination(Enter 1 for Nanjing, 2 for Beijing, 3 for Oulu, 4 for Helsinki)");
        String destination = scanner.next();
        flightbooking.setTripDestination(source,destination);
        flightbooking.setClassification(source,destination);

        System.out.println(flightbooking);

    }

}
