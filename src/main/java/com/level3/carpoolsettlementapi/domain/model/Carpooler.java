package com.level3.carpoolsettlementapi.domain.model;


import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carpooler {
    private Long carpoolerId;
    private String carpoolerName;
    private Boolean isSettled;

    public static Carpooler of(Long carpoolerId, String carpoolerName, Boolean isSettled){
        return Carpooler.builder()
                .carpoolerId(carpoolerId)
                .carpoolerName(carpoolerName)
                .isSettled(isSettled)
                .build();
    }
}
