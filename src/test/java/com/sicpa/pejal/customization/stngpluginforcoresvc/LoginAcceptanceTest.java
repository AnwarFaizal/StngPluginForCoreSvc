package com.sicpa.pejal.customization.stngpluginforcoresvc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sicpa.pejal.customization.coresvccomponent.services.DeclarationRequest;
import com.sicpa.pejal.customization.coresvccomponent.services.DeclarationResponse;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author azainal
 */
@Slf4j
@ExtendWith(DropwizardExtensionsSupport.class)
public class LoginAcceptanceTest {

    private static DropwizardAppExtension<MainConfiguration> EXT = new DropwizardAppExtension<>(
            MainApplication.class,
            ResourceHelpers.resourceFilePath("config.yaml")
        );

//    @Test
    public void loginHandlerRedirectsAfterPost() {
        Client client = EXT.client();

        Response response;
        response = client.target(
                String.format("http://localhost:%d/declaration/declare", EXT.getLocalPort()))
                .request()
                .post(Entity.json(getDefaultDeclarationRequest()));
        
        log.info("Response: " + response.readEntity(DeclarationResponse.class));

    }
    
    private DeclarationRequest getDefaultDeclarationRequest() {
        return DeclarationRequest.builder()
                .productId("80024002233")
                .startHrc("ejwbccwwk")
                .endHrc("deknwewekcwe")
                .productId("21000210001")
                .build();
    }
}