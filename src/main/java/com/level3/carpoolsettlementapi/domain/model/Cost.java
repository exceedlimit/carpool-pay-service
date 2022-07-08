package com.level3.carpoolsettlementapi.domain.model;

import com.level3.carpoolsettlementapi.CostConstant;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Builder
@Table(name="cost")
public class Cost {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Party party;

    @Embedded
    private Driver driver;

    @ElementCollection
    List<Carpooler> carpoolerList;

    private Integer totalCost;

    private Integer memberCost;

    //Todo static 빼고 instance method로 하고 이벤트로 받아서 하기...
    // 그 다음에 여기서 뭔가 처리를 할때는 그냥 조회가능한만큼 다 뽑아온다음에 거기서 포문돌린다.
    // 이 상태는 코스트가 안바뀐다는 확정...
    // 인원수가 다 채워진다음에 한번에 넘어온다 생각했는데 취소할수도 있고 인원도 바뀔수 있고...
    public static Cost of(Party party, Driver driver, List<Carpooler> carpoolerList){
        return Cost.builder()
                .party(party)
                .driver(driver)
                .carpoolerList(carpoolerList)
                .totalCost((int) (party.getDistance() * CostConstant.kmPerFee))
                .memberCost(((int) (party.getDistance() * CostConstant.kmPerFee))/(carpoolerList.size() + 1))
                .build();
    }




}
