package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.BusinessRule;
import com.TOSAD.Reparatie.Domain.BusinessRuleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusinessRuleTableRepository extends JpaRepository<BusinessRuleTable, Long> {

    @Query("select bt from BusinessRuleTable bt where bt.businessRule = ?1")
    BusinessRuleTable findByBusinessRule(BusinessRule businessRule);
}
