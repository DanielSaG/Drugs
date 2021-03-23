/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.service;

import com.danielsg.drugs.dto.DrugRequest;
import com.danielsg.drugs.dto.DrugResponse;
import java.util.List;

/**
 *
 * @author danie
 */
public interface DrugService {
    
    public long createDrug(DrugRequest drug);
    public void updateDrug(long drugId,DrugRequest drug);
    public List<DrugResponse> retrieveDrugs();
    public DrugResponse retrieveDrugById(long id);
    public void deleteDrug(long drugId);
    
}
