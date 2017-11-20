package hu.uni.miskolc.iit.webdevelopment.examples.cars.controller;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.controller.dto.CarRegistrationRequest;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.CarManagerService;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingPlateNumber;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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


    @RequestMapping(value={"/register"}, method={RequestMethod.POST}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void register(@RequestBody CarRegistrationRequest registrationRequest) throws ExistingPlateNumber {
//        System.out.println(registrationRequest.toString());
//        return registrationRequest.toString();
        Car car = new Car(registrationRequest.getPlateNo(), registrationRequest.getBrand(), registrationRequest.getModel(),
                new Color(registrationRequest.getColor().getRed(), registrationRequest.getColor().getGreen(), registrationRequest.getColor().getBlue()));
        carManager.recordCar(car);
    }

    @ExceptionHandler(value = {ExistingPlateNumber.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public String existingPlateNoExHandler(Exception ex){
        return ex.getMessage();
    }

}
