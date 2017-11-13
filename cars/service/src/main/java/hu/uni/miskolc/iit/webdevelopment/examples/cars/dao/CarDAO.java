package hu.uni.miskolc.iit.webdevelopment.examples.cars.dao;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.CarRecordAlreadyExistsException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;

import java.util.Collection;

/**
 * Created by tothzs on 2017.11.13..
 *
 * CRUD Methods for Car obejcts
 */
public interface CarDAO {

    Collection<Car> readCars();
    Collection<Car> readCarsByBrand(String brand);

    void createCar(Car car) throws CarRecordAlreadyExistsException;
}
