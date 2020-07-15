package com.TOSAD.Reparatie.DTO;

import com.TOSAD.Reparatie.Domain.*;

public class Converter {

    public static BusinessRuleDTO businessRuleToDTO(BusinessRule businessRule, BusinessRuleTable businessRuleTables, BusinessRuleColumns businessRuleColumns, BusinessRuleAttributes businessRuleAttributes) {
        BusinessRuleDTO businessRuleDTO = new BusinessRuleDTO();
        businessRuleDTO.setId(businessRule.getId());
        businessRuleDTO.setCode(businessRule.getCode());
        businessRuleDTO.setName(businessRule.getName());
        businessRuleDTO.setDescription(businessRule.getDescription());
        businessRuleDTO.setScriptType(businessRule.getScriptType());
        businessRuleDTO.setStatement(businessRule.getStatement());
        businessRuleDTO.setScript(businessRule.getScript());
        businessRuleDTO.setOperators(businessRule.getOperators());
        businessRuleDTO.setBusinessRuleTables(businessRuleTableToDTO(businessRuleTables));
        businessRuleDTO.setBusinessRuleColumns(businessRuleColumnsToDTO(businessRuleColumns));
        businessRuleDTO.setBusinessRuleAttributes(businessRuleAttributesToDTO(businessRuleAttributes));

        return businessRuleDTO;
    }

    public static BusinessRuleTableDTO businessRuleTableToDTO (BusinessRuleTable businessRuleTable) {
        BusinessRuleTableDTO businessRuleTableDTO = new BusinessRuleTableDTO();
        businessRuleTableDTO.setTable(businessRuleTable.getTable());
        return businessRuleTableDTO;
    }

    public static BusinessRuleColumnsDTO businessRuleColumnsToDTO (BusinessRuleColumns businessRuleColumns) {
        BusinessRuleColumnsDTO businessRuleColumnsDTO = new BusinessRuleColumnsDTO();
        businessRuleColumnsDTO.setColumns(businessRuleColumns.getColumns());
        return businessRuleColumnsDTO;
    }

    public static BusinessRuleAttributesDTO businessRuleAttributesToDTO (BusinessRuleAttributes businessRuleAttributes) {
        BusinessRuleAttributesDTO businessRuleAttributesDTO = new BusinessRuleAttributesDTO();
        businessRuleAttributesDTO.setAttributes(businessRuleAttributes.getAttributes());
        return businessRuleAttributesDTO;
    }
}