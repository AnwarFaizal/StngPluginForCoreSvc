/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sicpa.pejal.customization.stngpluginforcoresvc.rules;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sicpa.pejal.customization.coresvccomponent.data.PackagingUnit;
import com.sicpa.pejal.customization.coresvccomponent.data.Product;
import com.sicpa.pejal.customization.coresvccomponent.rules.ValidationRule;
import com.sicpa.pejal.customization.coresvccomponent.services.ValidationRequest;
import com.sicpa.pejal.customization.stngpluginforcoresvc.data.ProductExtensionSchema;
import com.sicpa.pejal.customization.stngpluginforcoresvc.data.PuExtensionSchema;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author azainal
 */
@Slf4j
public class MatchCodeTypeRule extends ValidationRule {
    
    @Override
    public String getDescription(){
        return "STNG CodeType matching rule";
    }

    @Override
    public boolean execute(ValidationRequest request) {
        log.debug("Validating with " + getDescription());
        if (request != null && request.getPuId() != null) {
            PackagingUnit pu = getPackagingUnit(request.getPuId());
            Product product = getProduct(request.getProductId());
            if(pu != null && product != null) {
                String puSchemaStr = getExtensionSchema(pu);
                String productSchemaStr = getExtensionSchema(product);
                if(StringUtils.isNotBlank(puSchemaStr) && StringUtils.isNotBlank(puSchemaStr)){
                    ObjectMapper mapper = new ObjectMapper();
                    PuExtensionSchema puSchema = mapper.convertValue(puSchemaStr, PuExtensionSchema.class);
                    ProductExtensionSchema prodSchema = mapper.convertValue(productSchemaStr, ProductExtensionSchema.class);
                    
                    if(puSchema != null && prodSchema != null) {
                        if (puSchema.getCodeType().equals(prodSchema.getCodeType())) {
                            log.debug("Passed " + getDescription());
                            return true;
                        }
                    }
                    
                    
                }
            }
        }
        return false;
    }
    
}
