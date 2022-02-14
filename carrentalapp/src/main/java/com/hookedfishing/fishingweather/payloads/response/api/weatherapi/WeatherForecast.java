package com.hookedfishing.fishingweather.payloads.response.api.weatherapi;

public class WeatherForecast {

    private WeatherAPI weatherAPI;
    private CurrentWeather currentWeather;

    public WeatherForecast() {
    }

    public WeatherAPI getWeatherAPI() {
        return weatherAPI;
    }

    public void setWeatherAPI(WeatherAPI weatherAPI) {
        this.weatherAPI = weatherAPI;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }
}
