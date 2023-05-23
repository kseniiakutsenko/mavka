package com.example.mavka.weatherapi;

import com.example.mavka.weatherapi.model.WeatherApiResponse;
import com.example.mavka.weatherapi.model.WeatherData;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.Locale;

@Service
public class WeatherApiService {

    public static final String DATA_URL = "https://api.open-meteo.com/v1/forecast?latitude=%.2f&longitude=%.2f&hourly=temperature_2m,windspeed_10m,winddirection_10m&forecast_days=1";

    public WeatherData getWeatherData(@JsonProperty(required = true) float latitude, @JsonProperty(required = true) float longitude) {
        RestTemplate restTemplate = new RestTemplate();

        String url = getUrlAtCoordinates(latitude, longitude);
        ResponseEntity<WeatherApiResponse> response = restTemplate.getForEntity(url, WeatherApiResponse.class);

        WeatherApiResponse data = response.getBody();

        return convertResponseToCurrentData(data);
    }

    private WeatherData convertResponseToCurrentData(WeatherApiResponse data) {
        ZonedDateTime currentTime = ZonedDateTime.now();
        int currentHour = currentTime.getHour();
        int offsetInHours = currentTime.getOffset().getTotalSeconds() / 60 / 60;
        int dataIndex = currentHour - offsetInHours;

        WeatherApiResponse.HourlyData hourlyData = data.getHourly();

        return new WeatherData(hourlyData.getTemperature().get(dataIndex), hourlyData.getWindSpeed().get(dataIndex), hourlyData.getWindDirection().get(dataIndex));
    }

    private String getUrlAtCoordinates(float latitude, float longitude) {
        return String.format(Locale.US, DATA_URL, latitude, longitude);
    }
}
