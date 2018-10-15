package hu.iit.uni.miskolc.webdevelopment.tsp.controller;

import hu.iit.uni.miskolc.webdevelopment.tsp.map.dto.City;
import hu.iit.uni.miskolc.webdevelopment.tsp.map.dto.ErrorCause;
import hu.iit.uni.miskolc.webdevelopment.tsp.map.dto.ErrorMessage;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.MapManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Controller
public class MapController {


    private MapManager mapManagerService;

    public MapController(@Autowired MapManager mapManagerService) {
        this.mapManagerService = mapManagerService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }

    @RequestMapping(value = {"/cities"})
    @ResponseBody
    public Collection<City> listCities(){
        Collection<City> result = new ArrayList<>();
        for(hu.iit.uni.miskolc.webdevelopment.tsp.model.City city : mapManagerService.listCities()){
            City c = new City();
            c.setName(city.getName());
            result.add(c);
        }
        return result;
    }


    @ExceptionHandler(FileNotFoundException.class)
    public ErrorMessage fileNotFoundExceptionHandler(Exception ex){
        System.out.println(ex.toString());
        ErrorMessage result = new ErrorMessage();
        result.setCode(BigInteger.valueOf(100));
        result.setCause(ErrorCause.DATABASE_IS_UNAVAILABLE);
        return result;
    }
}
