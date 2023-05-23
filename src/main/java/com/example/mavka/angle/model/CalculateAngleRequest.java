package com.example.mavka.angle.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record CalculateAngleRequest(@JsonProperty(required = true) long shellId,
                                    @JsonProperty(required = true) Coordinates start,
                                    @JsonProperty(required = true) Coordinates finish) {
}
