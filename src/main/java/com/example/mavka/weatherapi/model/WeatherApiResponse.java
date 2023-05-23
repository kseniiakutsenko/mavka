package com.example.mavka.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class WeatherApiResponse {

    private HourlyData hourly;

    @Getter
    @Setter
    @ToString
    public static class HourlyData {

        private List<Date> time;

        @JsonProperty("temperature_2m")
        private List<Float> temperature;

        @JsonProperty("windspeed_10m")
        private List<Float> windSpeed;

        @JsonProperty("winddirection_10m")
        private List<Integer> windDirection;

    }
}
