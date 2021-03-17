/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.mappers;

import com.danielsg.drugs.dto.DrugRequest;
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
public interface DrugRequestMapper {
    @Mappings({
      @Mapping(target="buyIndividualPrice", source="source.buyPrice"),
      @Mapping(target="sellIndividualPrice", source="source.sellPrice")
    })
    Drug DrugRequestToDrug(DrugRequest source);
    List<Drug> DrugRequestListToDrugList(List<DrugRequest> source);
    
    @Mappings({
      @Mapping(target="buyPrice", source="source.buyIndividualPrice"),
      @Mapping(target="sellPrice", source="source.sellIndividualPrice")
    })
    DrugRequest DrugToDrugRequest(Drug source);
    List<DrugRequest> DrugListToDrugRequestList(List<Drug> source);
}
