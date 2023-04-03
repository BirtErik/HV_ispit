package Main;

import java.util.List;

public interface VehicleManager {
    void AddToFleet(Vehicle vehicle) throws DuplicateVehicleException;
    void DeleteFromFleet(int vin) throws NoSuchVehicleException;
    void SearchFleetVin(int vin) throws NoSuchVehicleException;
    void SearchFleetModel(String model) throws NoSuchVehicleException;
    void SearchFleetMake(String make) throws NoSuchVehicleException;
    List<Vehicle> GetAllFleet();


}
