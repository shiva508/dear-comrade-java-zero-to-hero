package com.comrade.model;

import java.time.ZonedDateTime;

public interface Tour {
    String origin();
    String destination();
    ZonedDateTime departureTime();
    ZonedDateTime arrivalTime();
}
