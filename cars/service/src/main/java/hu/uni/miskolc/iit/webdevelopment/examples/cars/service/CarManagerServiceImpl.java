package hu.uni.miskolc.iit.webdevelopment.examples.cars.service;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.CarDAO;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.CarRecordAlreadyExistsException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarProducer;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarPrototype;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.exceptions.InvalidProductionDateExeption;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.CarManagerService;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingPlateNumber;

import java.awt.*;
import java.util.Collection;
import java.util.Date;

/**
 *
 */
public class CarManagerServiceImpl implements CarManagerService
{
    private CarDAO dao;

    public CarManagerServiceImpl(CarDAO dao) {
        this.dao = dao;
    }

    public Collection<Car> listCars() {
        return dao.readCars();
    }

    public Collection<Car> listCarsbyBrand(CarProducer producer) {
        return dao.readCars(producer);
    }

    public void recordCar(Car car) throws ExistingPlateNumber {
        try{
            dao.createCar(car);
        } catch (CarRecordAlreadyExistsException e) {
            /*
            We implement real exception handling.
            Not like this:
            e.printStackTrace();
            */
            //Sophisticated Exception Handling
            throw new ExistingPlateNumber(e);
        }
    }

    public void recordCar(String plateNo, CarPrototype prototype, Color color, Date productionDate) throws ExistingPlateNumber, InvalidProductionDateExeption {
        Car car = new Car(plateNo, prototype, color,productionDate);
        this.recordCar(car);
    }
}
