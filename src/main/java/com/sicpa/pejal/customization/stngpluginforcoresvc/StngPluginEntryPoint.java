/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sicpa.pejal.customization.stngpluginforcoresvc;

import com.sicpa.pejal.customization.coresvccomponent.rules.PluginEntryPoint;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author azainal
 */
@Slf4j
public class StngPluginEntryPoint extends PluginEntryPoint {

    @Override
    public String getDescription(){
        
        return "STNG specific entryPoint";
    }
 
}
