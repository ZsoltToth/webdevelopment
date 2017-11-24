package hu.uni.miskolc.iit.webdevelopment.examples.cars.service;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarBodyStyle;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarProducer;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarPrototype;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingCarPrototypeException;

import java.util.Collection;

/**
 * Define methods for querying and recording Car Prototypes.
 */
public interface CarPrototypeManagerService {

    /**
     *
     * @return Returns with all car prototypes recorded in the system.
     */
    Collection<CarPrototype> listCarPrototypes();

    /**
     * Return with each matching prototypes.
     * A prototype matches if the keyword is part of the prototypeId.
     * @param keyword it should be a single word.
     * @return returns with matching prototypes
     */
    Collection<CarPrototype> listCarPrototypes(String keyword);

    /**
     *
     * @param producer Selected car producer
     * @return Collection of prototypes of the selected producer
     */
    Collection<CarPrototype> listCarPrototypes(CarProducer producer);

    /**
     *
     * @param bodyStyle selected body style
     * @return collection of the prototypes with the selected body style.
     */
    Collection<CarPrototype> listCarPrototypes(CarBodyStyle bodyStyle);

    /**
     * Record a new Car Prototype into the system.
     * If there is a car prototype in the system whose id matches with the current prototype, then exception will be thrown.
     * @param prototype prototype which will be recorded
     * @throws ExistingCarPrototypeException if the prototype exists in the system.
     */
    void recordCarPrototype(CarPrototype prototype) throws ExistingCarPrototypeException;
}
