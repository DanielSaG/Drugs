/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.entities;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * Entidad Drug(medicamento) asociada al microservicio 
 * que representa un paquete de medicamentos
 * existentes para una sucursal
 */
@Data
@Entity
public class Drug implements Serializable{
    
    
    /** Tipo de medicamento */
    public static enum DrugType{ANALGESICO,ANTIACIDO,ANTIALERGICO,ANTIDIARREICO,LAXANTE,
                        ANTIINFECCIOSO, ANTIINFLAMATORIO,ANTIPIREPTICO,ANTITUSIVO,
                        MUCOLITICO, ANTIULCEROSO;
    public static String enumToString(){
        return Arrays.stream(DrugType.values())
                .map(t->t.toString())
                .collect(Collectors.joining(","));
    }};
    public static enum PharmForm{TABLET,CAPSULE,OINTMENT,PASTE,MOISTURIZER,SOLUTION,
                        INJECTION,SYRUP,OXIGEN,LOTION,SPRAY};
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="drug_id")
    private long id;
    private String name;
    private String brand;
    private String lab;
    @Enumerated(value = EnumType.STRING)
    private DrugType type;
    private String constituent;
    @Column(name="buy_individual_price")
    private float buyIndividualPrice;
    @Column(name="sell_individual_price")
    private float sellIndividualPrice;
    private int quantity;
    private boolean patent;
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name="expire_date")
    private Date expireDate;
    private int location;
    @Temporal(TemporalType.DATE)
    @Column(name="buy_date")
    private Date buyDate;
    @Enumerated(value = EnumType.STRING)
    @Column(name="pharmaceutical_form")
    private PharmForm pharmaceuticalForm;
    private String dosis; //unicamente cuando son pastillas o capsulas
    private String content;
    
    @Override
    public String toString(){
        StringBuilder str=new StringBuilder("");
        str.append("id: ")
                .append(id)
                .append("name: ")
                .append(name)
                .append("brand: ")
                .append(brand)
                .append("lab: ")
                .append(lab)
                .append("type: ")
                .append(type)
                .append("constituent: ")
                .append(constituent)
                .append("buyIndividualPrice: $")
                .append(buyIndividualPrice)
                .append("sellIndividualPrice: $")
                .append(sellIndividualPrice)
                .append("quantity: ")
                .append(quantity)
                .append("patent: ")
                .append(patent)
                .append("description: ")
                .append(description.substring(0,15))
                .append("expireDate: ")
                .append(expireDate)
                .append("location: ")
                .append(location)
                .append("buyDate: ")
                .append(buyDate)
                .append("pharmaceuticalForm: ")
                .append(pharmaceuticalForm)
                .append("content: ")
                .append(content)
                .append("dosis: ")
                .append(dosis);
        return str.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Drug))
            return false;
        Drug drug=(Drug)o;
        if(drug.id != this.id)
            return false;
        return drug.toString().hashCode() == this.toString().hashCode();
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = (int) (41 * hash + this.id);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.brand);
        hash = 41 * hash + Objects.hashCode(this.lab);
        hash = 41 * hash + Objects.hashCode(this.type);
        hash = 41 * hash + Objects.hashCode(this.pharmaceuticalForm);
        hash = 41 * hash + Objects.hashCode(this.content);
        hash = 41 * hash + Objects.hashCode(this.dosis);
        hash = 41 * hash + Objects.hashCode(this.constituent);
        hash = 41 * hash + (this.patent ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.expireDate);
        return hash;
    }
    
    public void setName(String name){
        this.name=name.toLowerCase();
    }
    public void setBrand(String brand){
        this.brand=brand.toLowerCase();
    }
    public void setLab(String lab){
        this.lab=lab.toLowerCase();
    }
    public void setConstituent(String constituent){
        this.constituent=constituent.toLowerCase();
    }
    
    
}
