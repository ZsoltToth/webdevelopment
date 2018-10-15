package hu.iit.uni.miskolc.webdevelopment.tsp.service;

import hu.iit.uni.miskolc.webdevelopment.tsp.dao.CityDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.PathDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.exception.DuplicatedEntryException;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.City;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.NegativePathCostException;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.Path;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.exception.CityAlreadyExistException;
import hu.iit.uni.miskolc.webdevelopment.tsp.service.exception.ZeroLengthLoopException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MapManagerImpl implements MapManager {

    private CityDAO cityDAO;
    private PathDAO pathDAO;

    public MapManagerImpl(CityDAO cityDAO, PathDAO pathDAO) {
        this.cityDAO = cityDAO;
        this.pathDAO = pathDAO;
    }

    @Override
    public Collection<City> listCities() {
        return cityDAO.readCities();
    }

    @Override
    public void recordCity(City city) throws CityAlreadyExistException {
        try {
            cityDAO.createCity(city);
        } catch (DuplicatedEntryException e) {
            throw new CityAlreadyExistException(e);
        }
    }

    @Override
    public Collection<Path> listPaths() {
        return pathDAO.readPaths();
    }

    @Override
    public Collection<Path> listPaths(City city) {
        Set<Path> result = new HashSet<>();
        result.addAll(listPathsFromCity(city));
        result.addAll(listPathsToCity(city));
        return result;
    }

    @Override
    public Collection<Path> listPathsToCity(City city) {
        Set<Path> result = new HashSet<>();
        for(Path path : pathDAO.readPaths()){
            if(city.equals(path.getDestination())){
                result.add(path);
            }
        }
        return result;
    }

    @Override
    public Collection<Path> listPathsFromCity(City city) {
        Set<Path> result = new HashSet<>();
        for(Path path : pathDAO.readPaths()){
            if(city.equals(path.getSource())){
                result.add(path);
            }
        }
        return result;
    }

    @Override
    public void insertPath(City source, City destination, double cost) {
        try {
            pathDAO.createPath(new Path(source,destination,cost));
        } catch (DuplicatedEntryException e) {
            e.printStackTrace();
        } catch (NegativePathCostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUndirectedPath(City source, City destination, double cost) throws ZeroLengthLoopException {
        insertPath(source,destination,cost);
        insertPath(destination,source,cost);
    }
}
