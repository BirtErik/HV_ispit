package Main;

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

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
