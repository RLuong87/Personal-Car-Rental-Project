package com.carrental.carrentalapp.controllers;

import com.carrental.carrentalapp.api.response.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Value("${FishingWeatherApp.app.weatherApiKey}")
    private String apiKey;

    @GetMapping("/weathertest")
    public String weatherTest() {
        return "WEATHER TEST!";
    }

    @GetMapping("/forecast/{q}")
    public ResponseEntity<?> getForecast(RestTemplate restTemplate, @PathVariable String q) {

        String LOCATION = "Cranston";
        String uri = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + apiKey;

        Forecast forecast = restTemplate.getForObject(uri, Forecast.class);

        return ResponseEntity.ok(forecast);
    }
}
