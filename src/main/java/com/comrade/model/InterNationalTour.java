package com.comrade.model;

import java.time.ZonedDateTime;

public record InterNationalTour(String origin, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime, String passportNumber, String visaNumber) implements Tour {

}
