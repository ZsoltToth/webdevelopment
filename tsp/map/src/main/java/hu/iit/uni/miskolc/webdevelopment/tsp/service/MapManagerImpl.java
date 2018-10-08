package hu.iit.uni.miskolc.webdevelopment.tsp.service;

import hu.iit.uni.miskolc.webdevelopment.tsp.dao.CityDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.PathDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.City;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.Path;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.exception.CityAlreadyExistException;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.exception.ZeroLengthLoopException;

import java.util.Collection;

public class MapManagerImpl implements MapManager {

    private CityDAO cityDAO;
    private PathDAO pathDAO;

    @Override
    public Collection<City> listCities() {
        return null;
    }

    @Override
    public void recordCity(City city) throws CityAlreadyExistException {

    }

    @Override
    public Collection<Path> listPaths() {
        return null;
    }

    @Override
    public Collection<Path> listPaths(City city) {
        return null;
    }

    @Override
    public Collection<Path> listPathsToCity(City city) {
        return null;
    }

    @Override
    public Collection<Path> listPathsFromCity(City city) {
        return null;
    }

    @Override
    public void insertPath(City source, City destination, double cost) {

    }

    @Override
    public void insertUndirectedPath(City source, City destination, double cost) throws ZeroLengthLoopException {

    }
}
