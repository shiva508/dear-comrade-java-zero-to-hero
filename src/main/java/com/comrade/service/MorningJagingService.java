package com.comrade.service;

import com.comrade.model.CommonResponse;
import com.comrade.model.DynamicApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class MorningJagingService {


    public <T> T genericResponse(Class<T> clazzz, String url){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<T> forEntity = restTemplate.getForEntity(url, clazzz);
        return forEntity.getBody();
    }


}
