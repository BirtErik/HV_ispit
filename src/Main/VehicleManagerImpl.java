package Main;

import java.util.ArrayList;
import java.util.List;

public class VehicleManagerImpl implements VehicleManager {
    private List<Vehicle> fleet;
    public VehicleManagerImpl(){
        fleet = new ArrayList<>();
    }
    @Override
    public void AddToFleet(Vehicle vehicle) {
        for (var value : fleet){
            if(value.getVin() == vehicle.getVin()){
                //throw new IllegalArgumentException();
            }
        }
        fleet.add(vehicle);
    }

    @Override
    public void DeleteFromFleet(int vin) {
        boolean flag = false;
        for(var value : fleet){
            if(value.getVin() == vin){
                fleet.remove(value);
                flag = true;
            }
        }
        if (!flag){
            //throw new NoSuchVehicleException();
        }
    }

    @Override
    public void SearchFleetVin(int vin) {
        boolean flag = false;
        for (var value : fleet){
            if (value.getVin()==vin){
                System.out.println(value);
                flag = true;
            }
        }
        if(!flag){
            //throw
        }
    }

    @Override
    public void SearchFleetModel(String model) {
        boolean flag = false;
        for (var value : fleet){
            if (value.getModel().equalsIgnoreCase(model)){
                System.out.println(value);
                flag = true;
            }
        }
        if(!flag){
            //throw
        }
    }

    @Override
    public void SearchFleetMake(String make) {
        boolean flag = false;
        for(var value : fleet){
            if(value.getMake().equalsIgnoreCase(make)){
                System.out.println(value);
                flag = true;
            }
        }
        if(!flag){
            //throw
        }
    }

    @Override
    public List<Vehicle> GetAllFleet() {
        return new ArrayList<>(fleet);
    }

}
