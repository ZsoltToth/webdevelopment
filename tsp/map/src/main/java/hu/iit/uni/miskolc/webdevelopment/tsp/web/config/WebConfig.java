package hu.iit.uni.miskolc.webdevelopment.tsp.web.config;

import hu.iit.uni.miskolc.webdevelopment.tsp.dao.CityDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.PathDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.file.FileCityDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.file.FilePathDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.MapManager;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.MapManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.io.IOException;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hu.iit.uni.miskolc.webdevelopment.tsp.controller")
@PropertySource(value={"classpath:config/web.properties"})
public class WebConfig {

    @Value ("${database.city}")
    private String cityDBPath;

    @Bean
    public CityDAO cityDAO() throws IOException {


        System.out.println(cityDBPath);
        return new FileCityDAO(new File(cityDBPath));
    }

    @Bean
    public PathDAO pathDAO(){
        return new FilePathDAO(new File("paths.csv"));
    }

    @Bean
    public MapManager mapManagerService() throws IOException {
        MapManager result = new MapManagerImpl(cityDAO(),pathDAO());
        return result;
    }


}
