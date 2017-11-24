package hu.uni.miskolc.iit.webdevelopment.examples.cars.model;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.exceptions.InvalidProductionDateExeption;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

/**
 * Created by tothzs on 2017.11.24..
 */
public class CarTest {

    private Car swift;
    private static CarPrototype swiftPrototype;

    @BeforeClass
    public static void beforeClass(){
        swiftPrototype = new CarPrototype(CarProducer.SUZUKI,"Swift 1",CarBodyStyle.COUPE, 1992, "", 800,1200,4,40);
    }

    @Before
    public void setUp() throws ParseException, InvalidProductionDateExeption {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        swift = new Car("abc123",swiftPrototype,new Color(0,255,0), dateFormat.parse("2000-01-01"));
    }

    @Test(expected = InvalidProductionDateExeption.class)
    public void testInvalidProductionDateException() throws ParseException, InvalidProductionDateExeption {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        new Car("abc123",swiftPrototype,new Color(0,255,0), dateFormat.parse("1234-01-01"));
    }

    @Test
    public void testEqualsPlateNo() throws ParseException, InvalidProductionDateExeption {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Car swift2 = new Car("abc123",swiftPrototype,new Color(0,255,0), dateFormat.parse("2000-01-01"));
        assertTrue(swift.equals(swift2));
    }

}