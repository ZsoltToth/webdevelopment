package hu.iit.uni.miskolc.webdevelopment.tsp.dao.file;

import hu.iit.uni.miskolc.webdevelopment.tsp.dao.PathDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.exception.DuplicatedEntryException;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.City;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.NegativePathCostException;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.Path;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;

public class FilePathDAO implements PathDAO {

    private File database;
    private  static  final String FIELD_SEPARATOR = ",";

    public FilePathDAO(File database) {
        this.database = database;
    }

    @Override
    public void createPath(Path path) throws DuplicatedEntryException {
        if(readPaths().contains(path)){
            throw new DuplicatedEntryException(String.format("Path %s already exists",path.toString()));
        }
        try {
            FileWriter writer = new FileWriter(database);
            writer.append(String.format("%s"+FIELD_SEPARATOR+"%s"+FIELD_SEPARATOR+"%f", path.getSource().getName(),path.getDestination().getName(),path.getCost()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Path> readPaths() {
        Collection<Path> result = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(database));
            String line;
            while((line = reader.readLine()) != null){
                if("".equals(line)){continue;}
                String[] fields = line.split(FIELD_SEPARATOR);
                if(fields.length != 3){continue;}
                result.add(new Path(
                        new City(fields[0]),
                        new City(fields[1]),
                        Double.valueOf(fields[2]).doubleValue()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NegativePathCostException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updatePath(Path oldPath, Path newPath) {

    }

    @Override
    public void deletePath(Path path) {

    }

    @Override
    public void deletePath(City city) {

    }
}
