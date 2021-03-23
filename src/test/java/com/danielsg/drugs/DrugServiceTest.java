/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs;

import com.danielsg.drugs.dao.DrugDao;
import com.danielsg.drugs.dto.DrugRequest;
import com.danielsg.drugs.dto.DrugResponse;
import com.danielsg.drugs.entities.Drug;
import com.danielsg.drugs.mappers.DrugRequestMapper;
import com.danielsg.drugs.mappers.DrugResponseMapper;
import com.danielsg.drugs.service.DrugServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author danie
 */
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class DrugServiceTest {
   /* @MockBean
    private DrugDao drugDao;
    @InjectMocks
    private DrugServiceImp drugService;
    @MockBean
    private DrugRequestMapper reqMapper;
    @MockBean
    private DrugResponseMapper respMapper;
    
    
    
    
    @Test
    @DisplayName("test service")
    public void testCreateServ(){
        System.out.println("test service");
        Drug drug=new Drug();
        drug.setName("vantal");
        Drug drugR=new Drug();
        drugR.setId(4L);
        DrugRequest dr=new DrugRequest();
        dr.setName("vantal");
        DrugResponse dresp=new DrugResponse();
        dresp.setId(4);
        Mockito.when(drugDao.save(drug)).thenReturn(drugR);
        Mockito.when(reqMapper.DrugRequestToDrug(dr)).thenReturn(drug);
        Mockito.when(respMapper.DrugToDrugResponse(drugR)).thenReturn(dresp);
        long res=drugService.createDrug(dr);
        assertEquals(4L,res);
    }*/
}
