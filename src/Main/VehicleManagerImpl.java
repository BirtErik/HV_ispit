package Main;

import java.util.ArrayList;
import java.util.List;

public class VehicleManagerImpl implements VehicleManager {
    private List<Vehicle> fleet;
    public VehicleManagerImpl(){
        fleet = new ArrayList<>();
    }
    @Override
    public void AddToFleet(Vehicle vehicle) throws DuplicateVehicleException {
        for (var value : fleet){
            if(value.getVin() == vehicle.getVin()){
                throw new DuplicateVehicleException("Vehicle with this %d vin already exist in this fleet".formatted(vehicle.getVin()));
            }
        }
        fleet.add(vehicle);
    }

    @Override
    public void DeleteFromFleet(int vin) throws NoSuchVehicleException{
        boolean flag = false;
        for(var value : fleet){
            if(value.getVin() == vin){
                fleet.remove(value);
                flag = true;
            }
        }
        if (!flag){
            throw new NoSuchVehicleException(("Fleet doesn't contain a vehicle with this %d name " +
                    "and it cannot be deleted").formatted(vin));
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
    public void SearchFleetModel(String model) throws NoSuchVehicleException{
        boolean flag = false;
        for (var value : fleet){
            if (value.getModel().equalsIgnoreCase(model)){
                System.out.println(value);
                flag = true;
            }
        }
        if(!flag){
            throw new NoSuchVehicleException("Fleet doesn't contain a vehicle with this %s model name".formatted(model));
        }
    }

    @Override
    public void SearchFleetMake(String make) throws NoSuchVehicleException{
        boolean flag = false;
        for(var value : fleet){
            if(value.getMake().equalsIgnoreCase(make)){
                System.out.println(value);
                flag = true;
            }
        }
        if(!flag){
            throw new NoSuchVehicleException("Fleet doesn't contain a vehicle with this %s manufacturer's name".formatted(make));
        }
    }

    @Override
    public List<Vehicle> GetAllFleet() {
        return new ArrayList<>(fleet);
    }

}
