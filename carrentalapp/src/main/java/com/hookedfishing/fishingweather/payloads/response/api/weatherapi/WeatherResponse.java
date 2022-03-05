package com.hookedfishing.fishingweather.payloads.response.api.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private WeatherAPI[] location;

    public WeatherResponse() {
    }

//    public Object getLocation() {
//        return location;
//    }
//
//    public void setLocation(Object location) {
//        this.location = location;
//    }


    public WeatherAPI[] getLocation() {
        return location;
    }

    public void setLocation(WeatherAPI[] location) {
        this.location = location;
    }
}
