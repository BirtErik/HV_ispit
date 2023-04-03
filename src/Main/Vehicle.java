package Main;

import java.util.Date;
import java.util.Objects;

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
    public String toString(){
       return String.format("%s{make=%s, model=%s, year=%d, color=%s, vin=%d, fuelType=%s",
               getClass().getName(),getMake(),getModel(),getYear(),getColor(), getVin(),getFuelType());
    }

    public int getVin() {return vin;}

    public void setVin(int vin) throws IllegalArgumentException{
        if(vin<=0){
            throw new IllegalArgumentException("VIN cannot be less or equal of 0!");
        }else{
            this.vin = vin;
        }
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) throws IllegalArgumentException{
        if(Objects.equals(make, " ")){
            throw new IllegalArgumentException("Manufacturer cannot be empty string!");
        }else {
            this.make = make;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws IllegalArgumentException {
        if(Objects.equals(model, " ")){
            throw new IllegalArgumentException("Model cannot be empty string!");
        }else {
            this.model = model;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws IllegalArgumentException{
        Date currentDate = new Date();
        if(year<1890 && year>currentDate.getTime()+1){
            throw new IllegalArgumentException("Invalid year");
        }else {
            this.year = year;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws IllegalArgumentException{
        if(Objects.equals(color, " ")){
            throw new IllegalArgumentException("Color cannot be empty string!");
        }
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) throws IllegalArgumentException {
        if(fuelType.toLowerCase().contains("diesel") || fuelType.toLowerCase().contains("petrol")){
            this.fuelType = fuelType;
        }else {
            throw new IllegalArgumentException("Fuel type must be diesel or petrol!");
        }
    }
}
