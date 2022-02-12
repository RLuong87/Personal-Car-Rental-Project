package com.hookedfishing.payloads.api.response.weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private List<List<WeatherAPI>> forecast;

    public WeatherResponse() {
    }

    public WeatherResponse(List<List<WeatherAPI>> forecast) {
        this.forecast = forecast;
    }

    public List<List<WeatherAPI>> getForecast() {
        return forecast;
    }

    public void setForecast(List<List<WeatherAPI>> forecast) {
        this.forecast = forecast;
    }
}
