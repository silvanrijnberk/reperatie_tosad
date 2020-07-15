package com.TOSAD.Reparatie.DAO;

import com.TOSAD.Reparatie.Domain.BusinessRule;
import com.TOSAD.Reparatie.Domain.BusinessRuleAttributes;
import com.TOSAD.Reparatie.Domain.BusinessRuleColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusinessRuleAttributesRepository extends JpaRepository<BusinessRuleAttributes, Long> {

    @Query("select ba from BusinessRuleAttributes ba where ba.businessRule = ?1")
    BusinessRuleAttributes findByBusinessRule(BusinessRule businessRule);
}
