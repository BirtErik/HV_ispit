package Main;

public class Car extends Vehicle {
    private int numDoors;
    private String bodyStyle;

    public Car(String make, String model, int year, String color, int vin, String fuelType,
               int loadCapacity, int numDoors, String bodyStyle) {
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

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }
}
