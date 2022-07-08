package com.level3.carpoolsettlementapi.domain.repository;

import com.level3.carpoolsettlementapi.domain.model.Cost;
import com.level3.carpoolsettlementapi.domain.model.Driver;
import com.level3.carpoolsettlementapi.domain.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostRepository extends JpaRepository<Cost, Long> {

    List<Cost> findAllByDriverAndParty(Driver Driver, Party party);
}
