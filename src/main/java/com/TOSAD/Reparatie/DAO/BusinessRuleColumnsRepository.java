package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.BusinessRule;
import com.TOSAD.Reparatie.Domain.BusinessRuleColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusinessRuleColumnsRepository extends JpaRepository<BusinessRuleColumns, Long> {

    @Query("select bc from BusinessRuleColumns bc where bc.businessRule = ?1")
    BusinessRuleColumns findByBusinessRule(BusinessRule businessRule);
}
