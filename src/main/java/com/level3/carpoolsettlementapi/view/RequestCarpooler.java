package com.level3.carpoolsettlementapi.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor@AllArgsConstructor
public class RequestCarpooler {

    private Long carpoolerId;
    private String carpoolerName;
    private Boolean isSettled;
}
