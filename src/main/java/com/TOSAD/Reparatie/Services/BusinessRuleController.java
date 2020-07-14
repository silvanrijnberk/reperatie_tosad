package com.TOSAD.Reparatie.Services;

import com.TOSAD.Reparatie.DAO.BusinessRuleAttributesDAO;
import com.TOSAD.Reparatie.DAO.BusinessRuleColumnsDAO;
import com.TOSAD.Reparatie.DAO.BusinessRuleDAO;
import com.TOSAD.Reparatie.DAO.BusinessRuleTableDAO;
import com.TOSAD.Reparatie.Domain.BusinessRule;
import com.TOSAD.Reparatie.Domain.BusinessRuleAttributes;
import com.TOSAD.Reparatie.Domain.BusinessRuleColumns;
import com.TOSAD.Reparatie.Domain.BusinessRuleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.jar.Attributes;

@RestController
@RequestMapping("/businessRules")
public class BusinessRuleController {


    @Autowired
    BusinessRuleDAO businessRuleDAO;
    @Autowired
    BusinessRuleAttributesDAO businessRuleAttributesDAO;
    @Autowired
    BusinessRuleColumnsDAO businessRuleColumnsDAO;
    @Autowired
    BusinessRuleTableDAO businessRuleTableDAO;

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
    public ResponseEntity<BusinessRule> getBusinessRuleById(@PathVariable(value = "id") Long id) {
        BusinessRule businessRule = businessRuleDAO.findById(id);

        if (businessRule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(businessRule);
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
