package hu.uni.miskolc.iit.webdev.config;

import hu.uni.miskolc.iit.webdev.service.GreetingsService;
import hu.uni.miskolc.iit.webdev.service.impl.GreetingsHU;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tothzs on 2017.07.20..
 */
@Configuration
public class ExampleConfiguration {

    @Bean(name = "greetingsService")
    public GreetingsService initGreetingsService(){
        return  new GreetingsHU();
    }
}
