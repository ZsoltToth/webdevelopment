package hu.uni.miskolc.iit.webdevelopment.examples.cars.service;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingPlateNumber;

import java.util.Collection;

/**
 * Created by tothzs on 2017.11.13..
 */
public interface CarManagerService {

    Collection<Car> listCars();
    Collection<Car> listCarsbyBrand(String brand);

    void recordCar(Car car) throws ExistingPlateNumber;
}
