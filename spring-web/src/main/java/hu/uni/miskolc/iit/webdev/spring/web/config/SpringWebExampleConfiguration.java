package hu.uni.miskolc.iit.webdev.spring.web.config;

import hu.uni.miskolc.iit.webdev.spring.web.controller.CalculatorController;
import hu.uni.miskolc.iit.webdev.spring.web.controller.GreetingsController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by tothzs on 2017.10.16..
 */

@Configuration
public class SpringWebExampleConfiguration {

    @Bean
    public GreetingsController greetingsController(){
        return  new GreetingsController();
    }

    @Bean
    public CalculatorController calculatorController(){
        return new CalculatorController();
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver result = new InternalResourceViewResolver();
        result.setViewClass(JstlView.class);
        result.setPrefix("/WEB-INF/views");
        result.setSuffix(".html");
        return result;
    }
}
