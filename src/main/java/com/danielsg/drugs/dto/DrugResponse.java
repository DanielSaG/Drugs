/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.dto;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author danie
 */
@Data
public class DrugResponse {
    private int id;
    private String name;
    private String brand;
    private String lab;
    private String type;
    private String constituent;
    private float buyPrice;
    private float sellPrice;
    private int quantity;
    private boolean patent;
    private String description;
    private Date expireDate;
    private int location;
    private Date buyDate;
    private String pharmaceuticalForm;
    private String content;
    private String dosis;
}
