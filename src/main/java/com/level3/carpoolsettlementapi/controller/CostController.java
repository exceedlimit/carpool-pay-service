package com.level3.carpoolsettlementapi.controller;

import com.level3.carpoolsettlementapi.ApiResult;
import com.level3.carpoolsettlementapi.domain.model.Cost;
import com.level3.carpoolsettlementapi.service.CostService;
import com.level3.carpoolsettlementapi.view.RequestCost;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settlement")
@RequiredArgsConstructor
public class CostController {

    private final CostService costService;

    @PostMapping("/cost")
    public ApiResult saveCost(@RequestBody RequestCost requestCost){
        costService.saveCost(requestCost);
        return ApiResult.ok();
    }
    @GetMapping("/cost")
    public ApiResult<List<Cost>> getOpenPartyCost(
            @RequestParam Long driverId
    ){
        return ApiResult.ok(costService.getOpenPartyCost(driverId));
    }

}
