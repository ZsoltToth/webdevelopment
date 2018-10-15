package hu.iit.uni.miskolc.webdevelopment.tsp.controller;

import hu.iit.uni.miskolc.webdevelopment.tsp.map.dto.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Collection;

@Controller
public class MapController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World";
    }

    @RequestMapping(value = {"/cities"})
    @ResponseBody
    public Collection<City> listCities(){
        City c1 = new City();
        City c2 = new City();
        c1.setName("Miskolc");
        c2.setName("Debrecen");
        return Arrays.asList(c1,c2);
    }
}
