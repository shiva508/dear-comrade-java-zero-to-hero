package com.comrade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {

    private Integer userId;

    private Integer id;

    private String title;

    private String body;
}
