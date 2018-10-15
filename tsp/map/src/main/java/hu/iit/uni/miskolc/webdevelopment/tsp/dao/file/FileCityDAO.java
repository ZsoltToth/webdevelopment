package hu.iit.uni.miskolc.webdevelopment.tsp.dao.file;

import hu.iit.uni.miskolc.webdevelopment.tsp.dao.CityDAO;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.exception.DuplicatedEntryException;
import hu.iit.uni.miskolc.webdevelopment.tsp.dao.exception.RecordNotFoundException;
import hu.iit.uni.miskolc.webdevelopment.tsp.model.City;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;

public class FileCityDAO implements CityDAO {

    private File database;

    public FileCityDAO(File database) {
        this.database = database;
    }

    @Override
    public void createCity(City city) throws DuplicatedEntryException {
        for(City c : readCities()){
            if(c.equals(city)){
                throw new DuplicatedEntryException(String.format("%s city already exists",city.getName()));
            }
        }
    }

    @Override
    public Collection<City> readCities() {
        Collection<City> result = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(database));
            String line;
            while((line = reader.readLine())!= null){
                if(line.startsWith("#")){
                    continue;
                }
                if(line.startsWith("%")){
                    continue;
                }
                if("".equals(line)){continue;}
                result.add(new City(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println(database.getAbsolutePath());
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateCity(City oldCity, City newCity) throws RecordNotFoundException {

    }

    @Override
    public void deleteCity(City city) throws RecordNotFoundException {

    }
}
