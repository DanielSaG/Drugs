/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.controller;

import com.danielsg.drugs.common.APIExcpetionResponse;
import com.danielsg.drugs.dto.DrugRequest;
import com.danielsg.drugs.dto.DrugResponse;
import com.danielsg.drugs.service.DrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danie
 */
@RestController
@RequestMapping("/drugs")
@Api(tags="Drugs API")
public class DrugsController {
    private static final String RESOURCE_URI="/drugs/";
    
    @Autowired
    private DrugService drugService;
    
    @ApiOperation(value="Retrieve all drugs",notes = "Return 204 if no data found",response = DrugResponse.class)
    @ApiResponses(value={
        @ApiResponse(code=200, message="Data founded", response = DrugResponse.class),
        @ApiResponse(code=204, message="No drugs founded"),
        @ApiResponse(code=206, message="Incomplete information"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<DrugResponse>> retrieveAllDrugs(){
        return ResponseEntity.ok(drugService.retrieveDrugs());
    }
    @ApiOperation(value="Retrieve drug by id",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=200, message="Data founded", response = DrugResponse.class),
        @ApiResponse(code=206, message="Incomplete information", response = DrugResponse.class),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=404, message="Drug not found"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @GetMapping("/{drugId}")
    public ResponseEntity<DrugResponse> retrieveDrugById(@PathVariable long drugId){
        return ResponseEntity.ok(drugService.retrieveDrugById(drugId));
    }
    @ApiOperation(value="Create drug",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=201, message="Drug created", responseHeaders = {
                    @ResponseHeader(
                            name = "Location",
                            description = "The created resource id", 
                            response = String.class)}),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @PostMapping
    public ResponseEntity<?> createDrug(@RequestBody DrugRequest drugReq){
        long drugId=drugService.createDrug(drugReq);
        return ResponseEntity.created(URI.create(RESOURCE_URI+drugId)).build();   
    }
    @ApiOperation(value="Update drug",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=204, message="Drug updated"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @PutMapping("/{drugId}")
    public ResponseEntity<?> updateDrug(@PathVariable long drugId,@RequestBody DrugRequest drugReq){
        drugService.updateDrug(drugId, drugReq);
        return ResponseEntity.noContent().build();
    }
    @ApiOperation(value="Delete drug",notes = "")
    @ApiResponses(value={
        @ApiResponse(code=204, message="Drug succesfully deleted"),
        @ApiResponse(code=400, message="Bad request. Check input example"),
        @ApiResponse(code=401, message="Unathorized user"),
        @ApiResponse(code=500, message="Internal server error", response = APIExcpetionResponse.class)
    })
    @DeleteMapping("/{drugId}")
    public ResponseEntity<?> deleteDrug(@PathVariable long drugId){
        drugService.deleteDrug(drugId);
        return ResponseEntity.noContent().build();
    }
    
}
