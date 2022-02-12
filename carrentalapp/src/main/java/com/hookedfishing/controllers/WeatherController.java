package com.hookedfishing.controllers;

//@CrossOrigin
//@RestController
//@RequestMapping("/weather")
public class WeatherController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${FishingWeatherApp.app.weatherApiKey}")
//    private String apiKey;

//    @GetMapping("/weathertest")
//    public String weatherTest() {
//        return "WEATHER TEST!";
//    }
//
//    @GetMapping("/forecast/{q}")
//    public ResponseEntity<?> getForecast(@PathVariable String q) {
//
//        String LOCATION = "Cranston";
//        String uri = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + apiKey;
//
//        Forecast forecast = restTemplate.getForObject(uri, Forecast.class);
//
//        return ResponseEntity.ok(forecast);
//    }

//    @GetMapping("/news/{q}")
//    public ResponseEntity<?> getNewsArticles(@PathVariable String q) {
//        String uri = "https://newsapi.org/v2/everything?sortBy=popularity&apiKey=" + apiKey + "&q=" + q;
//
//        NewsResponse response = restTemplate.getForObject(uri, NewsResponse.class);
//
//        return ResponseEntity.ok(response.getArticles());
//    }


//    @GetMapping("/forecastv2")
//    public Object weatherInfo2(RestTemplate restTemplate) {
//
//        String LOCATION = "Cranston";
//        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=";
//
//        return restTemplate.getForObject(URL, Weather.class);
//    }

}
