package com.level3.carpoolsettlementapi;

public interface ApiStatusResponsible {
    Integer getCode();

    String getMessage();

    default boolean isFailed() {
        return false;
    }

    default boolean isSuccess() {
        return true;
    }
}