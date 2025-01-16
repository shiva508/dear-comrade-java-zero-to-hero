package com.comrade.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DynamicApiResponse<T> {
    private CommonResponse<T> data;
}
