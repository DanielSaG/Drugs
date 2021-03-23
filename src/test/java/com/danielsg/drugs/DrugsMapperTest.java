/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs;

import com.danielsg.drugs.dto.DrugRequest;
import com.danielsg.drugs.entities.Drug;
import com.danielsg.drugs.mappers.DrugRequestMapper;
import com.danielsg.drugs.mappers.DrugResponseMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author danie
 */
@SpringBootTest
public class DrugsMapperTest {
    @Autowired
    DrugRequestMapper reqMapper;
    @Autowired
    DrugResponseMapper respMapper;
    
    /*@Test
    public void testDrugRequestToDrug() {
        System.out.println("DrugRequestToDrug");
        DrugRequest source = new DrugRequest();
        source.setBrand("vantal");
        Drug expResult = reqMapper.DrugRequestToDrug(source); 
        Assertions.assertEquals(source.getBrand(),expResult.getBrand());
  
    }
    @Test
    public void testDrugRequestToDrug2() {
        
        Assertions.assertEquals(2,2);
  
    }*/
}
