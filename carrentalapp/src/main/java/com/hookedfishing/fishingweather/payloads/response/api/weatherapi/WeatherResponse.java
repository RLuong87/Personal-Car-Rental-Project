package com.hookedfishing.fishingweather.payloads.response.api.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private List<List<WeatherAPI>> location;

    public WeatherResponse() {
    }

    public List<List<WeatherAPI>> getLocation() {
        return location;
    }

    public void setLocation(List<List<WeatherAPI>> location) {
        this.location = location;
    }
}
