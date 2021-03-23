/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author danie
 */
@Data
@ApiModel(description="Modelo de peticion al API de Medicamentos")
public class DrugRequest implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(required = true,example = "vantal", notes="Nombre del medicamento")
    private String name;
    @ApiModelProperty(required = true,example = "vantal", notes="Marca de origen")
    private String brand;
    @ApiModelProperty(required = true,example = "grossman", notes="Laboratorio que lo produce")
    private String lab;
    @ApiModelProperty(required = true,notes ="Uno o varios de los siguientes valores separados por coma: ANALGESICO,ANTIACIDO,ANTIALERGICO,ANTIDIARREICO,LAXANTE,ANTIINFECCIOSO,ANTIINFLAMATORIO,ANTIPIREPTICO,ANTITUSIVO,MUCOLITICO, ANTIULCEROSO",example = "ANALGESICO,ANTIINFECCIOSO")
    private String type;
    @ApiModelProperty(required = true,example = "bencidamina", notes="Pricipio activo. Si es mas de uno, separado por comas")
    private String constituent;
    @ApiModelProperty(required = true,example = "30", notes="Precio al que se adquirio")
    private float buyPrice;
    @ApiModelProperty(required = true,example = "80", notes="Precio de venta")
    private float sellPrice;
    @ApiModelProperty(required = false,example = "20", notes="Unicamente se usa cuando se agregan elemntos al inventario. Cantidad de productos comprados")
    private int quantity;
    @ApiModelProperty(required = true,example = "true", notes="Indica si es de patente")
    private boolean patent;
    @ApiModelProperty(required = true,example = "Un analgesico eficiente que por su formula...", notes="Descripcion del producto")
    private String description;
    @ApiModelProperty(required = true,example = "2020-03-28", notes="Fecha de caducidad en formato YYYY-MM-DD")
    private Date expireDate;
    @ApiModelProperty(required = false,example = "25", notes="Unicamente se usa cuando se agregan elemntos al inventario. Id de la sucursal al que pertenecen")
    private int locationId;
    @ApiModelProperty(required = true,example = "2020-02-12", notes="Fecha en la que se adquirio el producto en formato YYYY-MM-DD")
    private Date buyDate;
    @ApiModelProperty(required = true,notes="Un solo valor de los indicados",example = "SOLUCION", allowableValues = "PASTILLA,CAPSULA,POMADA,PASTA,CREMA,SOLUCION,ENYECCION,JARABE,OXIGENO,LOCION,AEROSOL")
    private String pharmaceuticalForm;
    @ApiModelProperty(required = true,example = "30ml", notes="Contenido neto")
    private String content;
    @ApiModelProperty(required = false,example = "10mg", notes="Unicamente cuando son pastillas o capsulas. Indica la dosis individual")
    private String dosis;
    
}
