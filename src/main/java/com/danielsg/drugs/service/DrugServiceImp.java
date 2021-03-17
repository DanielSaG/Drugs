/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.service;

import com.danielsg.drugs.dao.DrugDao;
import com.danielsg.drugs.dto.DrugRequest;
import com.danielsg.drugs.dto.DrugResponse;
import com.danielsg.drugs.entities.Drug;
import com.danielsg.drugs.mappers.DrugRequestMapper;
import com.danielsg.drugs.mappers.DrugResponseMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author danie
 */
@Service
public class DrugServiceImp implements DrugService{
    
    @Autowired
    DrugDao drugDao;
    @Autowired
    DrugRequestMapper reqMapper;
    @Autowired
    DrugResponseMapper respMapper;

    @Override
    @Transactional
    public long createDrug(DrugRequest drug) {
        Drug mappedDrug=reqMapper.DrugRequestToDrug(drug);
        mappedDrug=drugDao.save(mappedDrug);
        return mappedDrug.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DrugResponse> retrieveDrugs() {
        return respMapper.DrugListToDrugResponseList(drugDao.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public DrugResponse retrieveDrugById(long id) {
        return respMapper.DrugToDrugResponse(drugDao.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public void deleteDrug(long drugId) {
        Drug drug=new Drug();
        drug.setId(drugId);
        drugDao.delete(drug);
        
    }

    @Override
    public void updateDrug(long drugId, DrugRequest drug) {
        Drug mappedDrug=reqMapper.DrugRequestToDrug(drug);
        mappedDrug.setId(drugId);
        drugDao.save(mappedDrug);
    }
    
}
