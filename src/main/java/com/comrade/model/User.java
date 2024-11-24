package com.comrade.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private Gender gender;
    private List<Address> addresses;


}
