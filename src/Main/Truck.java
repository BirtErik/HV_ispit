package Main;

/**
 * Child klasa Vehicle-a
 * @author Erik Birt
 */
public class Truck extends Vehicle{
    private int loadCapacity;

    public Truck(String make, String model, int year, String color, int vin, String fuelType, int loadCapacity) {
        super(make,model,year,color,vin,fuelType);
        setLoadCapacity(loadCapacity);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("loadCapacity=%d}",getLoadCapacity());
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) throws IllegalArgumentException{
        if(loadCapacity > 0 && loadCapacity <= 10000){
            this.loadCapacity = loadCapacity;
        }else {
            throw new IllegalArgumentException("Load capacity cannot be less than 0 or higher than 10000");
        }
    }
}
