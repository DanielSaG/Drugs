/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.service;

import com.danielsg.drugs.common.ProductRequest;
import com.danielsg.drugs.common.ProductResponse;
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
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author danie
 */
@Service
public class DrugServiceImp implements DrugService{
    

    @Autowired
    private DrugDao drugDao;
    @Autowired
    private DrugRequestMapper reqMapper;
    @Autowired
    private DrugResponseMapper respMapper;
    @Autowired
    private RestTemplate restTemplate;
    

    @Override
    @Transactional(rollbackFor = Exception.class)
    public long createDrug(DrugRequest drug) {
        
        Drug mappedDrug=reqMapper.DrugRequestToDrug(drug);
        mappedDrug=drugDao.save(mappedDrug);
        ProductRequest prodReq=new ProductRequest();
        prodReq.setSpecId(mappedDrug.getId());
        prodReq.setType("medicina");
        prodReq.setQuantity(drug.getQuantity());
        restTemplate.postForEntity("http://products-product/api/sps/helloworld/v1/products", prodReq, ProductResponse.class);
        return mappedDrug.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DrugResponse> retrieveDrugs() {
        /*RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl
    = "http://localhost:8081/api/sps/helloworld/v1/products/2";
    ResponseEntity<ProductResponse> response
    = restTemplate.getForEntity(fooResourceUrl, ProductResponse.class);*/
    //List<ProductResponse> product =response.getBody();
         //WebClient webClient = WebClient.create("http://localhost:8081/api/sps/helloworld/v1/products");
         //eurekaClient.getApplications().getRegisteredApplications().g
         
         //ResponseEntity<List<ProductResponse>> res=restTemplate.exchange("http://products-product/api/sps/helloworld/v1/products", HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductResponse>>(){});
         //List<ProductResponse> f= res.getBody();
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
    @Transactional
    public void updateDrug(long drugId, DrugRequest drug) {
        Drug mappedDrug=reqMapper.DrugRequestToDrug(drug);
        mappedDrug.setId(drugId);
        drugDao.save(mappedDrug);
    }
    
}