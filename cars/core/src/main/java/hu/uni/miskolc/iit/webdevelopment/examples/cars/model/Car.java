package hu.uni.miskolc.iit.webdevelopment.examples.cars.model;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class Car
{
    private String plateNo;
    private String brand;
    private String carModel;
    private Color color;

    public Car(String plateNo, String brand, String carModel, Color color) {
        this.plateNo = plateNo;
        this.brand = brand;
        this.carModel = carModel;
        this.color = color;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public String getBrand() {
        return brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof  Car)){
            return false;
        }
        return plateNo.equals(((Car)obj).plateNo);
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNo='" + plateNo + '\'' +
                ", brand='" + brand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", color=" + color +
                '}';
    }
}
