package com.comrade.model;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

public record Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {

    public Journey(String origin, List<String> via, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
        this.origin = Objects.requireNonNull(origin, "Origin cannot be null");
        this.via = Objects.requireNonNull(via, "Via cannot be null");
        this.destination = Objects.requireNonNull(destination, "Destination cannot be null");
        this.departureTime = Objects.requireNonNull(departureTime, "Departure time cannot be null");
        this.arrivalTime = Objects.requireNonNull(arrivalTime, "Arrival time cannot be null");
    }

    public Journey(String origin, String destination, ZonedDateTime departureTime, ZonedDateTime arrivalTime) {
        this(origin, List.of(), destination, departureTime, arrivalTime);
    }
}
