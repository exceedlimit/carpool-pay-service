package com.level3.carpoolsettlementapi.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDriver {
    private Long driverId;
    private String driverName;
    private String settlementUrl;
}
