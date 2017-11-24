package hu.uni.miskolc.iit.webdevelopment.examples.cars.service;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarProducer;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarPrototype;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.exceptions.InvalidProductionDateExeption;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingPlateNumber;

import java.awt.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by tothzs on 2017.11.13..
 */
public interface CarManagerService {

    /**
     *
     * @return Collection of all Cars
     */
    Collection<Car> listCars();

    /**
     *
     * @param producer
     * @return All car instances whose prototype belong the given producer.
     */
    Collection<Car> listCarsbyBrand(CarProducer producer);

    void recordCar(Car car) throws ExistingPlateNumber;

    /**
     * Record a new car into the system.
     *
     * @since 1.1
     * @param plateNo plate number which should be unique.
     * @param prototype prototype of the car.
     * @param color color of the car
     * @param productionDate date of the production. It should be later than the introduction of the prototype.
     * @throws ExistingPlateNumber if the given plate number already exists in the system.
     * @throws InvalidProductionDateExeption if the production date is earlier than the introduction of the prototype.
     */
    void recordCar(String plateNo, CarPrototype prototype, Color color, Date productionDate) throws ExistingPlateNumber, InvalidProductionDateExeption;
}
