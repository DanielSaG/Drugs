/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danielsg.drugs.common;

/**
 *
 * @author danie
 */
public class DrugsDependencies {
    public static enum ProductAPIPaths{
        
        BASE("http://products-product/products"),
        
        CREATE_PROD("/"),
        RETRIEVE_ALL_PROD("/"),
        RETRIEVE_PROD_BY_ID("/"),
        UPDATE_PROD("/"),
        UPDATE_PARTIAL("/"),
        DELETE("/");
        
        private final String resourcePath;

        private ProductAPIPaths(String resourcePath) {
            this.resourcePath = resourcePath;
        }
        
        public String getResourcePath(){
            return resourcePath;
        }
        
    }
}
