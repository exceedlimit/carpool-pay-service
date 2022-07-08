package com.level3.carpoolsettlementapi.domain.model;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private Long driverId;
    private String driverName;
    private String settlementUrl;

    public static Driver of(Long driverId, String driverName, String settlementUrl){
        return Driver.builder()
                .driverId(driverId)
                .driverName(driverName)
                .settlementUrl(settlementUrl)
                .build();
    }

}
