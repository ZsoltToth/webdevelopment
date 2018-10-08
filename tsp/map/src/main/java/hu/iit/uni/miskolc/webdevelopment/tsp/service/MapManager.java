package hu.iit.uni.miskolc.webdevelopment.tsp.service;

import hu.iit.uni.miskolc.webdevelopment.tsp.model.City;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.Path;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.exception.CityAlreadyExistException;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.exception.ZeroLengthLoopException;

import java.util.Collection;

public interface MapManager {

    Collection<City> listCities();
    void recordCity(City city) throws CityAlreadyExistException;

    Collection<Path> listPaths();
    Collection<Path> listPaths(City city);
    Collection<Path> listPathsToCity(City city);
    Collection<Path> listPathsFromCity(City city);

    void insertPath(City source, City destination, double cost);
    void insertUndirectedPath(City source, City destination, double cost) throws ZeroLengthLoopException;
}
