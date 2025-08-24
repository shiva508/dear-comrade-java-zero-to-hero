package com.comrade;

import com.comrade.model.*;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Hello world!
 *
 */
public class DearComradeJavaZeroToHero
{
    public static void main( String[] args )
    {
        ZonedDateTime departureTime = ZonedDateTime.now();
        ZonedDateTime arrivalTime = ZonedDateTime.now();
        List<String> via = List.of("Miryala Gudem", "Nalgonda" );
        Journey journey = new Journey("Thalla Malka Puram",via, "Hyderabad", departureTime, arrivalTime);
        System.out.println( "Journey from " + journey.origin() + " to " + journey.destination() + " departs at " + journey.departureTime() + " and arrives at " + journey.arrivalTime());

        System.out.println("========================PART-2========================");

    }

    public static void startNationalTour(Tour tour) {
        if (tour instanceof NationalTour nationalTour) {
            System.out.println("Starting national tour from " + nationalTour.origin() + " to " + nationalTour.destination()+" via " + nationalTour.location());
        } else if (tour instanceof InterNationalTour interNationalTour) {
            System.out.println("Starting international tour from " + interNationalTour.origin() + " to " + interNationalTour.destination()+" with passport number " + interNationalTour.passportNumber() + " and visa number " + interNationalTour.visaNumber());
        }
    }

    public static void startNationalTourSwitch(Tour tour) {
        switch (tour){
            case NationalTour nationalTour -> System.out.println("Starting national tour from " + nationalTour.origin() + " to " + nationalTour.destination()+" via " + nationalTour.location());
            case InterNationalTour interNationalTour -> System.out.println("Starting international tour from " + interNationalTour.origin() + " to " + interNationalTour.destination()+" with passport number " + interNationalTour.passportNumber() + " and visa number " + interNationalTour.visaNumber());
            default -> throw new IllegalStateException("Unexpected value: " + tour);
        }
    }

    public static void startNationalTourSwitchGuarded(Tour tour) {
        switch (tour){
            case NationalTour nationalTour when nationalTour.location().equals("India") -> System.out.println("Starting national tour from " + nationalTour.origin() + " to " + nationalTour.destination()+" via " + nationalTour.location());
            case InterNationalTour interNationalTour when interNationalTour.passportNumber().startsWith("A") -> System.out.println("Starting international tour from " + interNationalTour.origin() + " to " + interNationalTour.destination()+" with passport number " + interNationalTour.passportNumber() + " and visa number " + interNationalTour.visaNumber());
            case NationalTour nationalTour -> System.out.println("Starting national tour from " + nationalTour.origin() + " to " + nationalTour.destination()+" via " + nationalTour.location());
            case InterNationalTour interNationalTour -> System.out.println("Starting international tour from " + interNationalTour.origin() + " to " + interNationalTour.destination()+" with passport number " + interNationalTour.passportNumber() + " and visa number " + interNationalTour.visaNumber());
            default -> throw new IllegalStateException("Unexpected value: " + tour);
        }
    }

//    public static  void numberToString(int number){
//        String numberString = switch (number) {
//            case int s when s < 10 -> "One";
//            case int s when s < 20  -> "Two";
//            case int s when s < 30 -> "Three";
//            case int s when s < 40 -> "Four";
//            case int s when s < 50 -> "Five";
//            default -> "Unknown";
//        };
//    }

    public static void recordPatternMatching(Tour tour) {
        switch (tour){
            case NationalTour(String origin, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime, String location) -> System.out.println("Starting national tour from " + origin + " to " + destination+" via " + location);
            case InterNationalTour(String origin, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime, String passportNumber, String visaNumber) -> System.out.println("Starting international tour from " + origin + " to " + destination+" with passport number " + passportNumber + " and visa number " + visaNumber);
            default -> throw new IllegalStateException("Unexpected value: " + tour);
        }
    }

    public static void nestedPatternMatching(Ticket ticket) {
        switch (ticket){
            case Ticket(var pnr,
                        Route(String start, String end),
                        Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime),
                        Passenger(String name, String email, String phoneNumber))-> System.out.println("Ticket PNR: " + pnr + ", Route: " + start + " to " + end + ", Journey: " + origin + " to " + destination + ", Passenger: " + name);
            case Ticket(var pnr,
                        var route,
                        Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime),
                        Passenger(String name, String email, String phoneNumber))-> System.out.println("Ticket PNR: " + pnr + ", Journey: " + origin + " to " + destination + ", Passenger: " + name);
            default -> throw new IllegalStateException("Unexpected value: " + ticket);
        }
    }
}
