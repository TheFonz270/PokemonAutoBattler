package com.codeclan.FinalProject.PokemonAutoBattler.controllers;

import com.codeclan.FinalProject.PokemonAutoBattler.models.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class RestControllerTest {


    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/callclienthello")
    private String getHelloClient(){
        String uri = "http://localhost:8080/hello";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping(value = "/countries")
    public String getCountries(){
        String url = "https://restcountries.com/v3.1/all";
        RestTemplate restTemplate = new RestTemplate();
        String countries = restTemplate.getForObject(url, String.class);
        return countries;
    }


    @GetMapping(value = "/pokemon2")
    public static ResponseEntity<String> Pokemon2() {
        ResponseEntity<String> responseJson = null;
        try {
            final String resourceUrl = "https://pokeapi.co/api/v2/pokemon/bulbasaur";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("user-agent", "Application");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            responseJson = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, String.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(responseJson);
        return responseJson;
    };

}
