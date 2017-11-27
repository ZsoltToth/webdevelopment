package hu.uni.miskolc.iit.webdevelopment.examples.cars.dao;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.CarNotFoundException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.CarRecordAlreadyExistsException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarProducer;

import java.util.Collection;

/**
 * Created by tothzs on 2017.11.13..
 *
 * CRUD Methods for Car obejcts
 */
public interface CarDAO {

    /**
     *
     * @return all car object in the database.
     */
    Collection<Car> readCars();

    /**
     *
     * @param producer selected producer
     * @return return all car of the selected producer
     */
    Collection<Car> readCars(CarProducer producer);

    /**
     * Read a single car based on the plate number.
     * @param plateNo selected plate number
     * @return a car object. It should not return with null.
     * @throws CarNotFoundException if no car record is found in the database
     */
    Car readCar(String plateNo) throws CarNotFoundException;

    /**
     * Record car
     * @param car car which will be recorded
     * @throws CarRecordAlreadyExistsException if there is a car with the given plate number in the system.
     */
    void createCar(Car car) throws CarRecordAlreadyExistsException;
}
