package hu.iit.uni.miskolc.webdevelopment.tsp.dao;

import hu.iit.uni.miskolc.webdevelopment.tsp.dao.exception.DuplicatedEntryException;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.City;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.Path;

import java.util.Collection;

public interface PathDAO {

    void createPath(Path path) throws DuplicatedEntryException;
    Collection<Path> readPaths();
    void updatePath(Path oldPath, Path newPath);
    void deletePath(Path path);
    void deletePath(City city);

}
