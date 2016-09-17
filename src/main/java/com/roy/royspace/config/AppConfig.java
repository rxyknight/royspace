package com.roy.royspace.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by royren on 16/9/17.
 */
@Configurable
public class AppConfig {


    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                System.out.println("EmbeddedServletContainerFactory invoked");
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };

        tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
        return tomcat;
    }

    private Connector initiateHttpConnector() {
        Properties pros = new Properties();
        try {
            pros.load(new FileInputStream("config/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer serverPort = Integer.parseInt(pros.getProperty("server.port"));
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        if(serverPort == 443)
            connector.setPort(80);
        else
            connector.setPort(8080);
        connector.setSecure(false);
        connector.setRedirectPort(serverPort);

        return connector;
    }
}
