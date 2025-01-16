package com.comrade.model;

import lombok.Data;

@Data
public class Shape<T> {
    private T dimensions;
}
