/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sicpa.pejal.customization.stngpluginforcoresvc.rules;

import com.sicpa.pejal.customization.coresvccomponent.data.Product;
import com.sicpa.pejal.customization.coresvccomponent.rules.DeclarationPreProcessor;
import com.sicpa.pejal.customization.coresvccomponent.services.DeclarationRequest;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author azainal
 */
@Slf4j
public class LastStatusPreprocessor extends DeclarationPreProcessor {
    
    @Override 
    public String getDescription(){
        return "Process via LastStatusPreprocessor";
    }
    
    @Override
    public Product execute(DeclarationRequest request, Product product) {
        log.debug("Executing " + getDescription());
        if(product == null){
                product = getProduct(request.getProductId());
        }
        product.setStatus("DECLARED");
        // Do something to the validated product
        return product;
    }
    
}
