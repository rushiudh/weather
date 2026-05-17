package com.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeather(double latitude, double longitude) {
        String url =
                "https://api.open-meteo.com/v1/forecast" +
                        "?latitude=" + latitude +
                        "&longitude=" + longitude +
                        "&current_weather=true";
        return restTemplate.getForObject(url, String.class);
    }
}
