package com.comrade.model;

import java.util.Objects;

public record Route(String start, String end) {
    public Route{
        Objects.requireNonNull(start, "");
        Objects.requireNonNull(end, "");
    }
}