package com.example.mavka.angle;

import com.example.mavka.angle.model.CalculateAngleRequest;
import com.example.mavka.weatherapi.WeatherApiService;
import com.example.mavka.weatherapi.model.WeatherData;
import org.springframework.stereotype.Service;

@Service
public class AngleService {

    private final WeatherApiService weatherApiService;

    public AngleService(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    public float calculateAngle(CalculateAngleRequest request) {
        NativeCallsClass nativeCalls = new NativeCallsClass();
        WeatherData weatherData = weatherApiService.getWeatherData(request.start().latitude(), request.start().longitude());
        double cr_1 = request.start().latitude();
        double cr_2 = request.start().longitude();
        double cr_3 = request.finish().latitude();
        double cr_4 = request.finish().longitude();
        double temp_m = weatherData.temperature();
        double result = nativeCalls.getA(cr_1, cr_2, cr_3, cr_4, temp_m, 6);

        return (float) result;
    }

}
