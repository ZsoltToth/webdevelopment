package hu.uni.miskolc.iit.webdevelopment.examples.cars.controller;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.CarManagerService;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * Hello world!
 *
 */
@RequestMapping("/cars")
public class CarController
{
   private CarManagerService carManager;

    public CarController(CarManagerService carManager) {
        this.carManager = carManager;
    }

    @RequestMapping(value = {"/"}, method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Car> listAllCars(){
        return carManager.listCars();
    }

    @RequestMapping(value = {"/{brandName}"}, method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<Car> listAllCarsOfBrand( @PathVariable(value = "brandName") String brand){
        return carManager.listCarsbyBrand(brand);
    }


}
