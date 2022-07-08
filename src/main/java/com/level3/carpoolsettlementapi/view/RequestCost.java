package com.level3.carpoolsettlementapi.view;

import com.level3.carpoolsettlementapi.domain.model.Carpooler;
import com.level3.carpoolsettlementapi.domain.model.Driver;
import com.level3.carpoolsettlementapi.domain.model.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCost {

    private RequestParty party;

    private RequestDriver driver;

    private List<RequestCarpooler> carpoolerList;

    public Party convertParty(){
        return Party.of(party.getPartyId(), party.getDistance(), false);
    }

    public Driver convertDriver(){
        return Driver.of(driver.getDriverId(), driver.getDriverName(), driver.getSettlementUrl());
    }

    public List<Carpooler> carpoolerList(){
        return carpoolerList.stream()
                .map(o-> Carpooler.of(o.getCarpoolerId(),o.getCarpoolerName(),o.getIsSettled()))
                .collect(Collectors.toList());
    }


}
