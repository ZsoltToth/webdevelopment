package hu.uni.miskolc.iit.webdev.spring.web.config;

import hu.uni.miskolc.iit.webdev.spring.web.controller.GreetingsController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tothzs on 2017.10.16..
 */

@Configuration
public class SpringWebExampleConfiguration {

    @Bean
    public GreetingsController greetingsController(){
        return  new GreetingsController();
    }
}
