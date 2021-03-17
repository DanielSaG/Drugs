/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.mappers;

import com.danielsg.drugs.dto.DrugResponse;
import com.danielsg.drugs.entities.Drug;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * @author danie
 */
@Mapper(componentModel = "spring")
public interface DrugResponseMapper {
    @Mappings({
      @Mapping(target="buyIndividualPrice", source="source.buyPrice"),
      @Mapping(target="sellIndividualPrice", source="source.sellPrice")
    })
    Drug DrugResponseToDrug(DrugResponse source);
    List<Drug> DrugResponseListToDrugList(List<DrugResponse> source);
    
    @Mappings({
      @Mapping(target="buyPrice", source="source.buyIndividualPrice"),
      @Mapping(target="sellPrice", source="source.sellIndividualPrice")
    })
    DrugResponse DrugToDrugResponse(Drug source);
    List<DrugResponse> DrugListToDrugResponseList(List<Drug> source);
}
