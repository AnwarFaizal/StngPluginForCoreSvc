/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sicpa.pejal.customization.stngpluginforcoresvc;

import com.sicpa.pejal.customization.coresvccomponent.services.ValidationService;
import com.sicpa.pejal.customization.stngpluginforcoresvc.rules.LastStatusPreprocessor;
import com.sicpa.pejal.customization.stngpluginforcoresvc.rules.MatchCodeTypeRule;
import com.sicpa.pejal.customization.stngpluginforcoresvc.rules.StngSiteValidationRule;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author azainal
 */
@Slf4j
public class MainApplication extends Application<MainConfiguration> {
    
    public static void main(String[] args) throws Exception {
        StngPluginEntryPoint entryPoint = new StngPluginEntryPoint();
        entryPoint.addValidationRule(new StngSiteValidationRule());
        entryPoint.addValidationRule(new MatchCodeTypeRule());
        entryPoint.addDeclarationPreProcessor(new LastStatusPreprocessor());
        new MainApplication(entryPoint).run(args);
    }
    
    public MainApplication() {
        log.debug("Init MainApplication::default");
    }
    
    public MainApplication(StngPluginEntryPoint entryPoint) {
        this.entryPoint = entryPoint;
    }
    
    @Override
    public void initialize(Bootstrap<MainConfiguration> bootstrap) {
        entryPoint.addBootstrapBundle(bootstrap);
    }
    
    private StngPluginEntryPoint entryPoint;

    @Override
    public void run(MainConfiguration config, Environment env) throws Exception {
        log.debug("STNG Entry will be configured, and start initializing the services.");
        entryPoint.setConfig(config).setEnvironment(env).run();
        entryPoint.getDescription();
    }
    
    
}
