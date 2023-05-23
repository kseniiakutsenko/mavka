package com.example.mavka.angle.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Coordinates(@JsonProperty(required = true) float latitude,
                          @JsonProperty(required = true) float longitude) {
}
