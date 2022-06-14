package com.flab.kream.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.stream.Stream;


public enum Gender {
    M("M"), F("F");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Gender findByCode(String code) {
        return Stream.of(Gender.values()).filter(c -> c.value.equals(code)).findFirst().orElse(null);
    }
}
