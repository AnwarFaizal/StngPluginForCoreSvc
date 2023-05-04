/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sicpa.pejal.customization.stngpluginforcoresvc.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 *
 * @author azainal
 */
@Data
@Builder
@Jacksonized
public class ProductExtensionSchema {
    
    @JsonProperty("code_type")
    private Integer codeType;
    
    @JsonProperty("status")
    private String status;
    
}
