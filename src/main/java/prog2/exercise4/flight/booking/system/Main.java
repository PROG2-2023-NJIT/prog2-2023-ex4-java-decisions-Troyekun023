package prog2.exercise4.flight.booking.system;


import java.util.Scanner;


import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        Scanner GQK = new Scanner(System.in);

        System.out.println("What is your name?");
        String name1 = GQK.nextLine();

        System.out.println("Give me the class you want to book (1:first, 2:bussiness, 3:economic) :");
        String str = GQK.nextLine();

        System.out.println("Give me the trip type you want to make (1:oneway, 2:return) :");
        String str2 = GQK.nextLine();

        System.out.println("Please give me where you from (1 for NANJING, 2 for BEIJING,3 for SHANGHAI,4 for OULU,5 for HELSINKI,6 for PARIS) :");
        String str3 = GQK.nextLine();  

        System.out.println("Please give me where you go (1 for NANJING, 2 for BEIJING,3 for SHANGHAI,4 for OULU,5 for HELSINKI,6 for PARIS) :");
        String str4 = GQK.nextLine(); 

        System.out.println("Give me the date  you depart in YYYY-MM-DD");
        String dep = GQK.nextLine();
        LocalDate departure = LocalDate.parse(dep);


        System.out.println("Give me the date  you return in theYYYY-MM-DD ");
        String ret = GQK.nextLine();
        LocalDate returning = LocalDate.parse(ret);

        System.out.println("How many children?");
        int childs = GQK.nextInt(); 

        System.out.println("How many children?");
        int adults = GQK.nextInt(); 

        GQK.close();

        FlightBooking FB1 = new FlightBooking(name1,departure,returning,childs,adults);

        FB1.setBookingClass(str);
        FB1.setTripType(str2);
        FB1.setTripSource(str3);
        FB1.setTripDestination(str3, str4);
        
        FB1.setDepartureDate(departure);
        FB1.setReturnDate(returning);

        FB1.getTicketNumber();

        FB1.setDepartingTicketPrice(childs,adults);
        FB1.setReturnTicketPrice();
        FB1.setTotalTicketPrice();


        System.out.println(FB1);
    }
    }
