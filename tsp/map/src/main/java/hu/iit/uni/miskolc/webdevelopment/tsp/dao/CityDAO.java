package hu.iit.uni.miskolc.webdevelopment.tsp.dao;

import hu.iit.uni.miskolc.webdevelopment.tsp.dao.exception.DuplicatedEntryException;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.exception.RecordNotFoundException;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.City;

import java.util.Collection;

public interface CityDAO {

    void createCity(City city) throws DuplicatedEntryException;
    Collection<City> readCities();
    void updateCity(City oldCity, City newCity) throws RecordNotFoundException;
    void deleteCity(City city) throws RecordNotFoundException;
}
