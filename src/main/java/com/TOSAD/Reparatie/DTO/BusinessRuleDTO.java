package com.TOSAD.Reparatie.DTO;

import com.TOSAD.Reparatie.Domain.*;

public class BusinessRuleDTO {

    private Long id;

    private String code;

    private String name;

    private String description;

    private String scriptType;

    private String statement;

    private Script script;

    private Operators operators;

    private BusinessRuleTableDTO businessRuleTables;

    private BusinessRuleColumnsDTO businessRuleColumns;

    private BusinessRuleAttributesDTO businessRuleAttributes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScriptType() {
        return scriptType;
    }

    public void setScriptType(String scriptType) {
        this.scriptType = scriptType;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Script getScript() {
        return script;
    }

    public void setScript(Script script) {
        this.script = script;
    }

    public Operators getOperators() {
        return operators;
    }

    public void setOperators(Operators operators) {
        this.operators = operators;
    }

    public BusinessRuleTableDTO getBusinessRuleTables() {
        return businessRuleTables;
    }

    public void setBusinessRuleTables(BusinessRuleTableDTO businessRuleTables) {
        this.businessRuleTables = businessRuleTables;
    }

    public BusinessRuleColumnsDTO getBusinessRuleColumns() {
        return businessRuleColumns;
    }

    public void setBusinessRuleColumns(BusinessRuleColumnsDTO businessRuleColumns) {
        this.businessRuleColumns = businessRuleColumns;
    }

    public BusinessRuleAttributesDTO getBusinessRuleAttributes() {
        return businessRuleAttributes;
    }

    public void setBusinessRuleAttributes(BusinessRuleAttributesDTO businessRuleAttributes) {
        this.businessRuleAttributes = businessRuleAttributes;
    }
}