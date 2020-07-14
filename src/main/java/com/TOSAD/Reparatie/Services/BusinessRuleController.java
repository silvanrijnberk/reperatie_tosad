package com.TOSAD.Reparatie.Services;

import com.TOSAD.Reparatie.DAO.BusinessRuleDAO;
import com.TOSAD.Reparatie.Domain.BusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/businessRules")
public class BusinessRuleController {


    @Autowired
    BusinessRuleDAO businessRuleDAO;

//    Save An BusinessRule
    @PostMapping("")
    public ResponseEntity<BusinessRule> createBusinessRule(@Valid @RequestBody BusinessRule businessRule) {
        return ResponseEntity.ok().body(businessRuleDAO.save(businessRule));
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
