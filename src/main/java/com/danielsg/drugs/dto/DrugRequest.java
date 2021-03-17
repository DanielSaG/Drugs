/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.dto;

import com.danielsg.drugs.entities.Drug;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author danie
 */
@Data
@ApiModel(description="general structure of a modify request")
public class DrugRequest {
    
    @ApiModelProperty(required = true,example = "vantal")
    private String name;
    @ApiModelProperty(required = true,example = "vantal")
    private String brand;
    @ApiModelProperty(required = true,example = "grossman")
    private String lab;
    @ApiModelProperty(required = true,allowableValues ="" ,example = "vantal")
    private String type;
    @ApiModelProperty(required = true,example = "bencidamina")
    private String constituent;
    @ApiModelProperty(required = true,example = "30")
    private float buyPrice;
    @ApiModelProperty(required = true,example = "80")
    private float sellPrice;
    @ApiModelProperty(required = true,example = "20")
    private int quantity;
    @ApiModelProperty(required = true,example = "true")
    private boolean patent;
    @ApiModelProperty(required = true,example = "An efficient analgesic with...")
    private String description;
    @ApiModelProperty(required = true,example = "2020-03-28")
    private Date expireDate;
    @ApiModelProperty(required = true,example = "vantal")
    private int location;
    @ApiModelProperty(required = true,example = "2020-02-12")
    private Date buyDate;
    @ApiModelProperty(required = true,example = "SOLUTION")
    private String pharmaceuticalForm;
    @ApiModelProperty(required = true,example = "30ml")
    private String content;
    @ApiModelProperty(required = true,example = "10mg")
    private String dosis;
}
