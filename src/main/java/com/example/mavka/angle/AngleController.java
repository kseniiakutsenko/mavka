package com.example.mavka.angle;

import com.example.mavka.angle.model.CalculateAngleRequest;
import com.example.mavka.angle.model.CalculateAngleResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AngleController {

    private final AngleService angleService;

    public AngleController(AngleService angleService) {
        this.angleService = angleService;
    }

    @PostMapping("/angle")
    public CalculateAngleResponse calculateAngle(@RequestBody CalculateAngleRequest calculateAngleRequest) {
        float angle = angleService.calculateAngle(calculateAngleRequest);
        return new CalculateAngleResponse(angle);
    }

}
