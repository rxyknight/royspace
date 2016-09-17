package com.roy.royspace;

import com.roy.royspace.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by royren on 16/9/3.
 * http://ec2-54-206-55-190.ap-southeast-2.compute.amazonaws.com
 */
@SpringBootApplication
@ImportResource("file:config/config.xml") //configuration file
@Import(AppConfig.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
