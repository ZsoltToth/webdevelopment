package hu.iit.uni.miskolc.webdevelopment.tsp.web.config;

import hu.iit.uni.miskolc.webdevelopment.tsp.controller.MapController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hu.iit.uni.miskolc.webdevelopment.tsp.controller")
public class WebConfig {

    @Bean
    public MapController mapController(){
        return new MapController();
    }
}
