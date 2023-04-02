package Main;

import java.util.List;

public interface VehicleManager {
    void AddToFleet(Vehicle vehicle);
    void DeleteFromFleet(int vin);
    void SearchFleetVin(int vin);
    void SearchFleetModel(String model);
    void SearchFleetMake(String make);
    List<Vehicle> GetAllFleet();


}
