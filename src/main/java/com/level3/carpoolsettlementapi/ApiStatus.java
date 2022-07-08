package com.level3.carpoolsettlementapi;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ApiStatus implements ApiStatusResponsible {
    SUCCESS(0, "성공"),
    ;
    private final Integer code;
    private final String message;

    ApiStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ApiStatus of(String message) {
        return Arrays.stream(ApiStatus.values())
                .filter(apiStatus -> apiStatus.getMessage().equals(message))
                .findFirst()
                .orElse(null);
    }
}
