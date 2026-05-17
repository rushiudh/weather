package com.weather.controller;

import com.weather.dto.Coordinates;
import com.weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeather(@RequestBody Coordinates coordinates) {
        return weatherService.getWeather(coordinates.latitude(), coordinates.longitude());
    }
}
