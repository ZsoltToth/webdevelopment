package hu.uni.miskolc.iit.webdevelopment.examples.cars.model;

import hu.uni.miskolc.iit.webdevelopment.examples.cars.model.exceptions.InvalidProductionDateExeption;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Car represents a concrete car instance that can be found on the roads.
 * Cars should match to prototypes and they have unique properties such as color or plate number.
 *
 * @see CarPrototype
 *
 */
public class Car
{
    /**
     * Plate number of the car which identifies the car in the system.
     */
    private String plateNo;
    private CarPrototype prototype;
    private Color color;
    private Date productionDate;

    /**
     * Car objects should be instantiated with a prototype.
     *
     * @param plateNo
     * @param prototype
     * @param color
     * @param productionDate
     * @throws InvalidProductionDateExeption
     */
    public Car(String plateNo, CarPrototype prototype, Color color, Date productionDate) throws InvalidProductionDateExeption {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(productionDate);
        if(calendar.get(Calendar.YEAR) < prototype.getYearOfIntroduction()){
            throw new InvalidProductionDateExeption(
                    String.format(
                            "Car would be produced earlier (%d) than the model was introduced (%d)",
                            calendar.get(Calendar.YEAR),
                            prototype.getYearOfIntroduction())
            );
        }
        this.plateNo = plateNo;
        this.prototype = prototype;
        this.color = color;
        this.productionDate = productionDate;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public Color getColor() {
        return color;
    }

    public CarProducer getProducer() {
        return prototype.getProducer();
    }

    public String getModel() {
        return prototype.getModel();
    }

    public CarBodyStyle getBodyStyle() {
        return prototype.getBodyStyle();
    }


    public int getCrubWeight() {
        return prototype.getCrubWeight();
    }

    public int getGrossVehicleWeight() {
        return prototype.getGrossVehicleWeight();
    }

    public DoorNumber getDoorNumber() {
        return prototype.getDoorNumber();
    }

    public double getEnginePerformance() {
        return prototype.getEnginePerformance();
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
                ", prototype=" + prototype +
                ", color=" + color +
                ", productionDate=" + productionDate +
                '}';
    }
}
