package prog2.exercise4.flight.booking.system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;


public class FlightBooking{

    public static final String FLIGHT_COMPANY = "Flights-Of-Fancy";

    private String passengerFullName;
    private int childPassengers;
    private int adultPassengers;
    public FlightBooking(String name,LocalDate dep1,LocalDate ret1,int child,int adult){
        passengerFullName = name;
        departureDate = dep1;
        returnDate = ret1;
        childPassengers = child;
        adultPassengers = adult;
    }

    public String getPassengerFullName(){
        return passengerFullName;
    }
    public int getchildPassengers(){
        return childPassengers;
    }
    public int getadultPassengers(){
        return adultPassengers;
    }

    private BookingClass bookingClass;
    enum BookingClass{FIRST,BUSINESS,ECONOMY}
    public BookingClass getBookingClass(){
        return bookingClass;
    }
    public void setBookingClass(String str){
        int num = Integer.parseInt(str);
        switch(num){
            case 1:
                bookingClass = BookingClass.FIRST;
                break;
            case 2:
                bookingClass = BookingClass.BUSINESS;
                break;
            case 3:
                bookingClass = BookingClass.ECONOMY;
                break;
            default:
                System.out.println("Sorry,you must log in 1,2 or 3");
        }
    }

    private TripType tripType;
    enum TripType{ONE_WAY,RETURN}
    public TripType getTripType(){
        return tripType;
    }
    public void setTripType(String str){
        int num = Integer.parseInt(str);
        switch(num){
            case 1:
                tripType = TripType.ONE_WAY;
                break;
            case 2:
                tripType = TripType.RETURN;
                break;
            default:
                System.out.println("Sorry,you must log in 1 or 2");
        }
    }

    private TripSource tripSource;
    enum TripSource{NANJING, BEIJING, SHANGHAI, OULU, HELSINKI,PARIS}
    enum SourceAirport{NANJING_LUKOU_INTERNATIONAL_Airport,BEIJING_CAPITAL_INTERNATIONAL_AIRPORT,SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT,OULU_HELSINKI_AIRPORT,PARIS_CHARLES_DE_GAULLE_AIRPORT} 
    public TripSource getTripSource(){
        return tripSource;
    }
    public void setTripSource(String str){
        int num = Integer.parseInt(str);
        switch(num){
            case 1:
                tripSource = TripSource.NANJING;
                break;
            case 2:
                tripSource = TripSource.BEIJING;
                break;
            case 3:
                tripSource = TripSource.SHANGHAI;  
                break;
            case 4:
                tripSource = TripSource.OULU; 
                break;          
            case 5:
                tripSource = TripSource.HELSINKI;
                break;
            case 6:
                tripSource = TripSource.PARIS;
                break;
            default:
            System.out.println("Sorry,you must log in 1,2,3,4,5 or 6");
        }
    }

    private TripDestination tripDestination;
    enum TripDestination{NANJING, BEIJING, SHANGHAI, OULU, HELSINKI,PARIS}
    enum DestinationAirport{NANJING_LUKOU_INTERNATIONAL_Airport,BEIJING_CAPITAL_INTERNATIONAL_AIRPORT,SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT,OULU_HELSINKI_AIRPORT,PARIS_CHARLES_DE_GAULLE_AIRPORT}
    public TripDestination getTripDestination(){
        return tripDestination;
    }
    public void setTripDestination(String SourceOfTrip,String DestinationOfTrip){
        int num3 = Integer.parseInt(SourceOfTrip);
        int num4 = Integer.parseInt(DestinationOfTrip);
        if(num3 != num4 ){
            switch(num4){
            case 1:
                tripDestination = TripDestination.NANJING;
                break;
            case 2:
                tripDestination = TripDestination.BEIJING;
                break;
            case 3:
                tripDestination = TripDestination.SHANGHAI; 
                break; 
            case 4:
                tripDestination = TripDestination.OULU;   
                break;        
            case 5:
                tripDestination = TripDestination.HELSINKI;
                break;
            case 6:
                tripDestination = TripDestination.PARIS;
                break;
            default:
            System.out.println("Sorry,you must log in 1,2,3,4,5 or 6");
            }

        } else{
            System.out.println("error! The trip source and the trip destination cannot be the same.");
        }
    }



    private LocalDate departureDate;  
    public LocalDate getDepartureDate(){
        return departureDate;
    }
    public void setDepartureDate(LocalDate depart){
        departureDate = depart;
    }

    private LocalDate returnDate; 
    int flag; 
    public LocalDate getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(LocalDate ret){
        long dayDifference = ChronoUnit.DAYS.between(departureDate,ret);
        if(dayDifference == 1){
            flag = 1;
            returnDate = departureDate.plusDays(2);
        } else if(dayDifference == 2){
            flag = 2;
            returnDate = departureDate.plusDays(1);
        }
        else{
            flag = 3;
            returnDate = ret;
        }
    }



    private String  ticketNumberThird = getTicketNumberThird(4);

    public String getTicketNumberThird(int length){
        String range = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer str = new StringBuffer();
        for(int i =0;i <length; i++){
            int number = random.nextInt(62);
            str.append(range.charAt(number));
        }
        return str.toString();
    }

    private String ticketNumber;
    private String ticketNumberFirst;
    private String ticketNumberSecond;
    private String ticketNumberLast;

    public String getTicketNumber(){
        if(tripType == TripType.ONE_WAY){ticketNumberFirst = "11";}       
        else{ticketNumberFirst = "22";}
        if(bookingClass == BookingClass.FIRST){ticketNumberSecond = "F";}
        else if(bookingClass == BookingClass.BUSINESS){ticketNumberSecond = "B";}
        else{ticketNumberSecond = "E";}
        if(tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING || tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING){ticketNumberLast = "DOM";}
        else if(tripSource == TripSource.OULU && tripDestination == TripDestination.HELSINKI || tripSource == TripSource.HELSINKI && tripDestination == TripDestination.OULU){ticketNumberLast = "DOM";}
        else {ticketNumberLast = "INT";}

        ticketNumber = ticketNumberFirst + ticketNumberSecond +ticketNumberThird +ticketNumberLast;
        return ticketNumber;
    }


    private int departingTicketPrice;
    public int getDepartingTicketPrice(){
        return departingTicketPrice;
    }
    public void  setDepartingTicketPrice(int child,int adult){
        int dtp;
        if(tripSource == TripSource.NANJING && tripDestination == TripDestination.BEIJING || tripSource == TripSource.BEIJING && tripDestination == TripDestination.NANJING || tripSource == TripSource.OULU && tripDestination == TripDestination.HELSINKI || tripSource == TripSource.HELSINKI && tripDestination == TripDestination.OULU)
        {dtp =345;}
       else {dtp = 375;}
    
    if (bookingClass == BookingClass.FIRST) {
        departingTicketPrice = (dtp * child) + (dtp * adult) + 250;
    } else if (bookingClass == BookingClass.BUSINESS) {
        departingTicketPrice = (dtp * child) + (dtp * adult) + 150;
    } else{
        departingTicketPrice = (dtp * child) + (dtp * adult) + 50;
    }
    }

    private int returnTicketPrice;
    private int totalTicketPrice;
    public void setReturnTicketPrice() {
        if (tripType == TripType.ONE_WAY) {
            returnTicketPrice = 0;
        } else {
            returnTicketPrice = departingTicketPrice;
        }
    }
    public void setTotalTicketPrice() {
        totalTicketPrice = departingTicketPrice + returnTicketPrice;
    }
    public int getTotalTicketPrice() {
        return totalTicketPrice;
    }

        


    public String toString(){
        if (flag == 1||flag == 2) {
            return "Thank you for booking your flight with " + FLIGHT_COMPANY + ". Following are the details of your bookingand the trip:\n\n" +
                    "Ticket Number: " + ticketNumber + "\n" +
                    "Passenger Name: " + passengerFullName + "\n" +
                    "From " + tripSource + " to " + tripDestination + "\n" +
                    "Date of departure: " + departureDate + "\n" +
                    "Date of return: " + returnDate + " (Changed from old " + returnDate.minusDays(flag) + " to new " + returnDate + ")" + "\n" +
                    "Total ticket price in Euros: " + totalTicketPrice + "\n\n" +
                    "IMPORTANT NOTICE: As per our policy, the returnDate was changed because it was less than two days apart from your departure date.";
        } else {
            return "Thank you for booking your flight with " + FLIGHT_COMPANY + ". Following are the details of your bookingand the trip:\n\n" +
                    "Ticket Number: " + ticketNumber + "\n" +
                    "Passenger Name: " + passengerFullName + "\n" +
                    "From " + tripSource + " to " + tripDestination + "\n" +
                    "Date of departure: " + departureDate + "\n" +
                    "Date of return: " + returnDate + "\n" +
                    "Total ticket price in Euros: " + totalTicketPrice + "\n";
        }

    }


}
