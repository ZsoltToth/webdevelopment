package hu.uni.miskolc.iit.webdevelopment.examples.cars.service;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.CarPrototypeDAO;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.dao.exceptions.PrototypeIDAlreadyExistsException;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarBodyStyle;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarProducer;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.CarPrototype;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.DoorNumber;
import hu.uni.miskolc.iit.webdevelopment.examples.cars.service.exceptions.ExistingCarPrototypeException;
import org.easymock.EasyMock;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by tothzs on 2017.11.27..
 */
public class CarPrototypeManagerServiceImplTest {

    private static final String SUZUKI_KEYWORD = "SUZUKI";
    private static final String OPEL_KEYWORD = "OPEL";
    private static final String DACIA_KEYWORD = "DACIA";
    private static final String SWIFT_KEYWORD = "Swift";
    private static final String A8_KEYWORD = "A8";

    private CarPrototypeManagerService service;

    private static CarPrototype swift;
    private static CarPrototype wagonr;
    private static CarPrototype duster;
    private static CarPrototype trabant;

    @BeforeClass
    public static void beforeClass(){
        swift = new CarPrototype(CarProducer.SUZUKI,"Swift 1", CarBodyStyle.COUPE, 1992, "", 800,1200, DoorNumber.FOUR,40);
        wagonr = new CarPrototype(CarProducer.SUZUKI,"WagonR", CarBodyStyle.COUPE, 1995, "", 1000,1500, DoorNumber.TWO,50);
        duster = new CarPrototype(CarProducer.DACIA,"Duster", CarBodyStyle.SUV, 2005, "", 1200,2000, DoorNumber.FOUR,70);
        trabant = new CarPrototype(CarProducer.TRABANT,"Trabant", CarBodyStyle.LUXURY_CAR, 1975, "", 500,1000, DoorNumber.FOUR,20);
    }


    @Before
    public void setUp() throws PrototypeIDAlreadyExistsException {
        CarPrototypeDAO dao = EasyMock.createMock(CarPrototypeDAO.class);

        EasyMock.expect(dao.readCarPrototypes()).andReturn(new ArrayList<>(Arrays.asList(swift, wagonr, duster))).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(CarProducer.SUZUKI)).andReturn(new ArrayList<>(Arrays.asList(swift, wagonr))).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(CarProducer.DACIA)).andReturn(new ArrayList<>(Arrays.asList(duster))).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(CarProducer.OPEL)).andReturn(new ArrayList<>()).anyTimes();

        EasyMock.expect(dao.readCarPrototypes(CarBodyStyle.SUV)).andReturn(new ArrayList<>(Arrays.asList(duster))).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(CarBodyStyle.COUPE)).andReturn(new ArrayList<>(Arrays.asList(swift, wagonr))).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(CarBodyStyle.LUXURY_CAR)).andReturn(new ArrayList<>()).anyTimes();

        EasyMock.expect(dao.readCarPrototypes(SUZUKI_KEYWORD)).andReturn(new ArrayList<>(Arrays.asList(swift, wagonr))).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(DACIA_KEYWORD)).andReturn(new ArrayList<>(Arrays.asList(duster))).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(OPEL_KEYWORD)).andReturn(new ArrayList<>()).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(SWIFT_KEYWORD)).andReturn(new ArrayList<>(Arrays.asList(swift))).anyTimes();
        EasyMock.expect(dao.readCarPrototypes(A8_KEYWORD)).andReturn(new ArrayList<>()).anyTimes();

        dao.createCarPrototype(trabant);

        dao.createCarPrototype(swift);
        EasyMock.expectLastCall().andThrow(new PrototypeIDAlreadyExistsException(swift.prototypeId()));

        dao.createCarPrototype(duster);
        EasyMock.expectLastCall().andThrow(new PrototypeIDAlreadyExistsException(duster.prototypeId()));

        dao.createCarPrototype(wagonr);
        EasyMock.expectLastCall().andThrow(new PrototypeIDAlreadyExistsException(wagonr.prototypeId()));


        EasyMock.replay(dao);
        this.service = new CarPrototypeManagerServiceImpl(dao);
    }

    @Test
    public void listCarPrototypes() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>(Arrays.asList(swift, wagonr, duster));
        Collection<CarPrototype> actual = service.listCarPrototypes();

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesSuzukiPrototypes() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>(Arrays.asList(swift, wagonr));
        Collection<CarPrototype> actual = service.listCarPrototypes(CarProducer.SUZUKI);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesDaciaPrototypes() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>(Arrays.asList(duster));
        Collection<CarPrototype> actual = service.listCarPrototypes(CarProducer.DACIA);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesOpelPrototypes() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>();
        Collection<CarPrototype> actual = service.listCarPrototypes(CarProducer.OPEL);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesSUVBodyStyle() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>(Arrays.asList(duster));
        Collection<CarPrototype> actual = service.listCarPrototypes(CarBodyStyle.SUV);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesCoupeBodyStyle() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>(Arrays.asList(swift, wagonr));
        Collection<CarPrototype> actual = service.listCarPrototypes(CarBodyStyle.COUPE);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesLuxuryBodyStyle() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>();
        Collection<CarPrototype> actual = service.listCarPrototypes(CarBodyStyle.LUXURY_CAR);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesSuzukiKeyword() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>(Arrays.asList(swift, wagonr));
        Collection<CarPrototype> actual = service.listCarPrototypes(SUZUKI_KEYWORD);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesDaciaKeyword() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>(Arrays.asList(duster));
        Collection<CarPrototype> actual = service.listCarPrototypes(DACIA_KEYWORD);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesOpelKeyword() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>();
        Collection<CarPrototype> actual = service.listCarPrototypes(OPEL_KEYWORD);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesSwiftKeyword() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>(Arrays.asList(swift));
        Collection<CarPrototype> actual = service.listCarPrototypes(SWIFT_KEYWORD);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void listCarPrototypesA8Keyword() throws Exception {
        Collection<CarPrototype> expected = new HashSet<>();
        Collection<CarPrototype> actual = service.listCarPrototypes(A8_KEYWORD);

        assertThat(actual, Matchers.containsInAnyOrder(expected.toArray(new CarPrototype[expected.size()])));
    }

    @Test
    public void recordCarPrototypeTrabant() throws Exception {
        service.recordCarPrototype(trabant);
    }

    @Test(expected = ExistingCarPrototypeException.class)
    public void recordCarPrototypeSwift() throws Exception {
        service.recordCarPrototype(swift);
    }



}