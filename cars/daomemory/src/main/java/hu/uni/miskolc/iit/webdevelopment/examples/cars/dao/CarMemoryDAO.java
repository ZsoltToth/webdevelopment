package hu.uni.miskolc.iit.webdevelopment.examples.cars.dao;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.CarRecordAlreadyExistsException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.Car;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Dummy Implementation of CarDAO Interface
 * It has predefined values and full of magic numbers.
 * See other subjects for proper implementation.
 */
public class CarMemoryDAO implements CarDAO
{
    private static Collection<Car> database;

    static {
        /*
        Set up a predefiend Database
         */
        database = new ArrayList<Car>(Arrays.asList(
                new Car("abc123","Audi","A4",Color.pink),
                new Car("def456","Suzuki","Swift",Color.green),
                new Car("ghi789","Opel","Corsa",Color.white)
        ));
    }

    public Collection<Car> readCars() {
        //See difference between shallow and deep copy
        return new HashSet<Car>(database);
    }

    public Collection<Car> readCarsByBrand(String brand) {
        Collection<Car> result = new HashSet<Car>();
        for(Car car : database){
            if(car.getBrand().equals(brand)){
                result.add(car);
            }
        }
        return result;
    }

    public void createCar(Car car) throws CarRecordAlreadyExistsException {
        for(Car record : database){
            if(record == null){
                continue;
            }
            if(record.equals(car)){
                throw new CarRecordAlreadyExistsException(car.getPlateNo());
            }
        }
        database.add(car);
    }
}
