package com.level3.carpoolsettlementapi.service;

import com.level3.carpoolsettlementapi.domain.model.Cost;
import com.level3.carpoolsettlementapi.domain.model.Driver;
import com.level3.carpoolsettlementapi.domain.model.Party;
import com.level3.carpoolsettlementapi.domain.repository.CostRepository;
import com.level3.carpoolsettlementapi.view.RequestCost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CostService {

    private final CostRepository costRepository;

    @Transactional
    public void saveCost(RequestCost requestCost){
        costRepository.save(Cost.of(requestCost.convertParty(),requestCost.convertDriver(),requestCost.carpoolerList()));
    }

    public List<Cost> getOpenPartyCost(Long driverId){
        return costRepository.findAllByDriverAndParty(Driver.of(driverId, null, null),
                Party.of(null, null, false));
    }
}
