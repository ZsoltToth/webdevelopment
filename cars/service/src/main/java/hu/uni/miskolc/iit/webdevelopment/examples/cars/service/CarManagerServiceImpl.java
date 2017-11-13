package hu.uni.miskolc.iit.webdevelopment.examples.cars.service;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.CarDAO;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.CarRecordAlreadyExistsException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.CarManagerService;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingPlateNumber;

import java.util.Collection;

/**
 * Hello world!
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

    public Collection<Car> listCarsbyBrand(String brand) {
        return dao.readCarsByBrand(brand);
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
}
