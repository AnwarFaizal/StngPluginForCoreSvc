/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sicpa.pejal.customization.stngpluginforcoresvc.rules;

import com.sicpa.pejal.customization.coresvccomponent.data.PackagingUnit;
import com.sicpa.pejal.customization.coresvccomponent.data.Product;
import com.sicpa.pejal.customization.coresvccomponent.rules.ValidationRule;
import com.sicpa.pejal.customization.coresvccomponent.services.ValidationRequest;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author azainal
 */
@Slf4j
@lombok.NoArgsConstructor
public class StngSiteValidationRule extends ValidationRule {
    
    @Override
    public String getDescription(){
        return "STNG specific site Validation rule";
    }

    @Override
    public boolean execute(ValidationRequest request) {
        log.debug("Validating with " + getDescription());
        if (request != null && request.getPuId() != null) {
            PackagingUnit pu = getPackagingUnit(request.getPuId());
            Product product = getProduct(request.getProductId());
            if(pu != null && product != null) {
                if(pu.getSiteId().equals(product.getSiteid())){
                    log.debug("Passed " + getDescription());
                    return true;
                }
            }
        }
        return false;
    }
}
