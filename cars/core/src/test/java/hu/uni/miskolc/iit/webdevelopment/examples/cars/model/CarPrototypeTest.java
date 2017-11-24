package hu.uni.miskolc.iit.webdevelopment.examples.cars.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tothzs on 2017.11.24..
 */
public class CarPrototypeTest {

    private CarPrototype prototype;

    @Before
    public void setUp(){
        this.prototype = new CarPrototype(CarProducer.SUZUKI,"Swift 1",CarBodyStyle.COUPE, 1992, "", 800,1200,4,40);
    }

    @Test
    public void testPrototypeId(){
        String expected = "SUZUKI_Swift 1_COUPE_1992";
        String actual = prototype.prototypeId();
        assertEquals(expected,actual);
    }
}