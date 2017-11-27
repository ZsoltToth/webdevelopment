package hu.uni.miskolc.iit.webdevelopment.examples.cars.dao;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.PrototypeIDAlreadyExistsException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarBodyStyle;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarProducer;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarPrototype;

import java.util.Collection;

/**
 * Provides CURD methods for {@link CarPrototype} class.
 * @author tothzs
 * @since 1.1
 */
public interface CarPrototypeDAO {

    /**
     *
     * @return all car prototypes
     */
    Collection<CarPrototype> readCarPrototypes();

    /**
     *
     * @param keyword car model or note
     * @return all car prototypes whose model or note contain the keyword
     */
    Collection<CarPrototype> readCarPrototypes(String keyword);

    /**
     *
     * @param producer selected car producer
     * @return all prototypes of the given producer
     */
    Collection<CarPrototype> readCarPrototypes(CarProducer producer);

    /**
     *
     * @param bodyStyle selected body style
     * @return all prototypes with the selected body style
     */
    Collection<CarPrototype> readCarPrototypes(CarBodyStyle bodyStyle);

    /**
     *
     * @param prototype record the prototype in the system
     * @throws PrototypeIDAlreadyExistsException if there is a prototype with the sam prototypeId
     * @see CarPrototype
     */
    void createCarPrototype(CarPrototype prototype) throws PrototypeIDAlreadyExistsException;
}
