package com.comrade;

import com.comrade.model.CommonCollectionResponse;
import com.comrade.model.CommonResponse;
import com.comrade.model.DynamicApiResponse;
import com.comrade.model.Post;
import com.comrade.service.MorningJagingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Slf4j
public class DearComradeJavaZeroToHero
{
    public static void main( String[] args ) {

        SpringApplication.run(DearComradeJavaZeroToHero.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(MorningJagingService morningJagingService){
        return args -> {
            String responseString = morningJagingService.genericResponse(String.class, "https://jsonplaceholder.typicode.com/posts");
            System.out.println(responseString);
            Post[] posts = morningJagingService.genericResponse(Post[].class, "https://jsonplaceholder.typicode.com/posts");
            List<Post> list = Arrays.asList(posts);
            System.out.println(list);
        };
    }
}
