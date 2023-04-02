package Main;
public abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;
    private int vin;
    private String fuelType;

    public Vehicle(String make, String model, int year, String color, int vin, String fuelType){
        setMake(make);
        setModel(model);
        setYear(year);
        setColor(color);
        setVin(vin);
        setFuelType(fuelType);
    }

    @Override
    public abstract String toString();

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
