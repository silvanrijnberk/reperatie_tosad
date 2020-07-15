package com.TOSAD.Reparatie.Services;

import com.TOSAD.Reparatie.DAO.*;
import com.TOSAD.Reparatie.DTO.BusinessRuleDTO;
import com.TOSAD.Reparatie.DTO.Converter;
import com.TOSAD.Reparatie.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/businessrules")
public class BusinessRuleController {


    @Autowired
    BusinessRuleDAO businessRuleDAO;
    @Autowired
    BusinessRuleAttributesDAO businessRuleAttributesDAO;
    @Autowired
    BusinessRuleColumnsDAO businessRuleColumnsDAO;
    @Autowired
    BusinessRuleTableDAO businessRuleTableDAO;
    @Autowired
    OperatorsDAO operatorsDAO;
    @Autowired
    ScriptDAO scriptDAO;

//    Save An BusinessRule
    @PostMapping("/{table}/{column}/{attributes}")
    public ResponseEntity<BusinessRule> createBusinessRule(@Valid @RequestBody BusinessRule businessRule,@PathVariable(value = "table") String table,@PathVariable(value = "column") String column,@PathVariable(value = "attributes") String attributes) {

        businessRuleDAO.save(businessRule);

        BusinessRuleAttributes businessRuleAttributes = new BusinessRuleAttributes();
        attributes = attributes.replace("_"," ");
        businessRuleAttributes.setAttributes(attributes);
        businessRuleAttributes.setBusinessRule(businessRule);

        BusinessRuleColumns businessRuleColumns= new BusinessRuleColumns();
        businessRuleColumns.setColumns(column);
        businessRuleColumns.setBusinessRule(businessRule);

        BusinessRuleTable businessRuleTable = new BusinessRuleTable();
        businessRuleTable.setTable(table);
        businessRuleTable.setBusinessRule(businessRule);

        businessRuleAttributesDAO.save(businessRuleAttributes);
        businessRuleColumnsDAO.save(businessRuleColumns);
        businessRuleTableDAO.save(businessRuleTable);
        return ResponseEntity.ok().body(businessRule);
    }

//    Find All BusinessRule
    @GetMapping("")
    public ResponseEntity<List<BusinessRule>> getAllBusinessRules() {
        return ResponseEntity.ok().body(businessRuleDAO.findAll());
    }

//    Find BusinessRule By Id
    @GetMapping("/{id}")
    public ResponseEntity<BusinessRuleDTO> getBusinessRuleById(@PathVariable(value = "id") Long id) {
        BusinessRule businessRule = businessRuleDAO.findById(id);

        if (businessRule == null) {
            return ResponseEntity.notFound().build();
        } else {
            BusinessRuleTable businessRuleTables = businessRuleTableDAO.findByBusinessRule(businessRule);
            BusinessRuleColumns businessRuleColumns = businessRuleColumnsDAO.findByBusinessRule(businessRule);
            BusinessRuleAttributes businessRuleAttributes = businessRuleAttributesDAO.findByBusinessRule(businessRule);
            BusinessRuleDTO businessRuleDTO = Converter.businessRuleToDTO(businessRule, businessRuleTables, businessRuleColumns, businessRuleAttributes);
            return ResponseEntity.ok().body(businessRuleDTO);
        }
    }

//    Delete BusinessRule By Id
    @DeleteMapping("/{id}")
    public ResponseEntity<BusinessRule> deleteBusinessRule(@PathVariable(value = "id") Long id) {
        BusinessRule businessRule = businessRuleDAO.findById(id);

        if (businessRule == null) {
            return ResponseEntity.notFound().build();
        }
        businessRuleDAO.delete(businessRule);

        return ResponseEntity.ok().body(businessRule);
    }
}
