package com.level3.carpoolsettlementapi.domain.model;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Party {
    private Long partyId;
    private Double distance;
    //Todo 이부분이 운행 종료되면 같이 업데이트 되어야 함.
    private Boolean isClosed;

    public static Party of(Long partyId, Double distance, Boolean isClosed){
        return Party.builder()
                .partyId(partyId)
                .distance(distance)
                .isClosed(isClosed)
                .build();
    }
}
