package hu.uni.miskolc.iit.webdevelopment.examples.cars.service;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.CarPrototypeDAO;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.PrototypeIDAlreadyExistsException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarBodyStyle;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarProducer;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarPrototype;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingCarPrototypeException;

import java.util.Collection;

/**
 * Implementation of {@link CarPrototypeManagerService}.
 *
 * @since 1.1
 * @author tothzs
 *
 * @see hu.uni.miskolc.iit.webdevelopment.examples.cars.service.CarPrototypeManagerService
 * @see CarPrototypeDAO
 *
 */
public class CarPrototypeManagerServiceImpl implements CarPrototypeManagerService {

    private CarPrototypeDAO dao;

    public CarPrototypeManagerServiceImpl(CarPrototypeDAO dao) {
        this.dao = dao;
    }

    public Collection<CarPrototype> listCarPrototypes() {
        return dao.readCarPrototypes();
    }

    public Collection<CarPrototype> listCarPrototypes(String keyword) {
        return dao.readCarPrototypes(keyword);
    }

    public Collection<CarPrototype> listCarPrototypes(CarProducer producer) {
        return dao.readCarPrototypes(producer);
    }

    public Collection<CarPrototype> listCarPrototypes(CarBodyStyle bodyStyle) {
        return dao.readCarPrototypes(bodyStyle);
    }

    public void recordCarPrototype(CarPrototype prototype) throws ExistingCarPrototypeException {
        try{
            dao.createCarPrototype(prototype);
        } catch (PrototypeIDAlreadyExistsException e) {
            throw new ExistingCarPrototypeException(String.format("%s already in use.",prototype.prototypeId()),e);
        }
    }
}
