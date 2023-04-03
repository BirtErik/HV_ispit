package Main;

import java.util.Objects;

/**
 * Child klasa Vehicle-a
 * @author Erik Birt
 */
public class Car extends Vehicle {
    private int numDoors;
    private String bodyStyle;

    public Car(String make, String model, int year, String color, int vin, String fuelType,
                int numDoors, String bodyStyle) {
        super(make,model,year,color,vin,fuelType);
        setNumDoors(numDoors);
        setBodyStyle(bodyStyle);
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", numDoors=%d, bodyStyle=%s}",getNumDoors(),getBodyStyle());
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) throws IllegalArgumentException {
        if (numDoors > 0 && numDoors <= 6){
            this.numDoors = numDoors;
        }else {
            throw new IllegalArgumentException("Number of doors cannot be less than 1 or higher than 6!");
        }

    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        if(Objects.equals(bodyStyle, " ")){
            throw new IllegalArgumentException("Body style cannot be empty string!");
        }else {
            this.bodyStyle = bodyStyle;
        }
    }
}
