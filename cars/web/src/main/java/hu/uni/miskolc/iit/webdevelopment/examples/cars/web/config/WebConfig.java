package hu.uni.miskolc.iit.webdevelopment.examples.cars.web.config;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.controller.CarController;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.CarDAO;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.CarMemoryDAO;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.CarManagerService;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.CarManagerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by tothzs on 2017.11.13..
 */
@Configuration
public class WebConfig {

    @Bean(value = "carDAO")
    public CarDAO initCarDAO(){
        return new CarMemoryDAO();
    }

    @Bean(value = "carManager")
    public CarManagerService initCarManagerService(){
        return new CarManagerServiceImpl(initCarDAO());
    }

    @Bean("carController")
    public CarController initCarController(){
        return new CarController(initCarManagerService());
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


