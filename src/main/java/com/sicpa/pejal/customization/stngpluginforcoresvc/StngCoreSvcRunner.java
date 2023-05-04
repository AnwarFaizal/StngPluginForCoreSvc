/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sicpa.pejal.customization.stngpluginforcoresvc;

import com.sicpa.pejal.customization.coresvccomponent.MainApplication;

/**
 *
 * @author azainal
 */
public class StngCoreSvcRunner {
    
    public static void main (String[] argv) throws Exception {
        new MainApplication("STNG Customization").run(argv);
    }
}
