package com.comrade.model;

import java.time.ZonedDateTime;
import java.util.List;

public record NationalTour (String origin, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime, String location) implements Tour{

}
