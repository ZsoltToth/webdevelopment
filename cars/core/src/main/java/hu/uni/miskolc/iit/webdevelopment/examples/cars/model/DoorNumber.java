package hu.uni.miskolc.iit.webdevelopment.examples.cars.model;

/**
 * Created by tothzs on 2017.11.24..
 */
public enum DoorNumber {


    ONE(1), TWO(2), THREE(3), FOUR(4),FIVE(5),OTHER(-1);

    private final int value;

    DoorNumber(int value) {
        this.value = value;
    }
}
