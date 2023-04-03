package Main;

import java.util.*;

/**
 * @author Erik Birt
 * Klasa implementira VehicleManager te sluzi kao kontrola nad citavim programom
 */
public class VehicleManagerImpl implements VehicleManager {
    private final List<Vehicle> fleet;
    private final Logging logger;

    public VehicleManagerImpl(){
        fleet = new ArrayList<>();
        logger = new Logging();
    }

    /**
     * Dodavanje vozila tipa Vehicle
     * @param vehicle objekt tipa Vehicle
     * @throws DuplicateVehicleException iznimka u slucaju da vozilo s dobivenim VIN-om vec postoji
     */
    @Override
    public void AddToFleet(Vehicle vehicle) throws DuplicateVehicleException {
        for (var value : fleet){
            if(value.getVin() == vehicle.getVin()){
                logger.LoggingError(new DuplicateVehicleException("Vehicle with this %d vin already exist in this fleet"
                        .formatted(vehicle.getVin())));
                throw new DuplicateVehicleException("Vehicle with this %d vin already exist in this fleet"
                        .formatted(vehicle.getVin()));
            }
        }
        fleet.add(vehicle);
        System.out.println("Vehicle added successfully");
    }

    /**
     * Brise vozilo iz flote
     * @param vin integer
     * @throws NoSuchVehicleException iznimka u slucaju da vozilo s dobivenim VIN-om ne postoji
     */
    @Override
    public void DeleteFromFleet(int vin) throws NoSuchVehicleException{
        boolean flag = false;
        for(Iterator<Vehicle> it = fleet.iterator(); it.hasNext();){
            Vehicle vehicle = it.next();
            if(vehicle.getVin() == vin){
                it.remove();
                System.out.println("Deleted successfully!");
                flag = true;
            }
        }
        if (!flag){
            logger.LoggingError(new NoSuchVehicleException(("Fleet doesn't contain a vehicle with this %d VIN " +
                    "and it cannot be deleted").formatted(vin)));
            throw new NoSuchVehicleException(("Fleet doesn't contain a vehicle with this %d VIN " +
                    "and it cannot be deleted").formatted(vin));
        }
    }
    /**
     * Pretraga flote
     * @param vin integer
     * @throws NoSuchVehicleException iznimka u slucaju da vozilo s dobivenim VIN-om ne postoji
     */
    @Override
    public void SearchFleetVin(int vin) throws NoSuchVehicleException{
        boolean flag = false;
        for (var value : fleet){
            if (value.getVin()==vin){
                System.out.println(value);
                flag = true;
            }
        }
        if(!flag){
            logger.LoggingError(new NoSuchVehicleException(("Fleet doesn't contain a vehicle with this %d VIN").formatted(vin)));
            throw new NoSuchVehicleException("Fleet doesn't contain a vehicle with this %d VIN".formatted(vin));
        }
    }

    /**
     * Pretraga flote
     * @param model String
     * @throws NoSuchVehicleException iznimka u slucaju da vozilo s dobivenim model-om ne postoji
     */
    @Override
    public void SearchFleetModel(String model) throws NoSuchVehicleException{
        boolean flag = false;
        for (var value : fleet){
            if (value.getModel().equalsIgnoreCase(model)){
                //System.out.println(value);
                flag = true;
            }
        }
        if(!flag){
            logger.LoggingError(new NoSuchVehicleException(("Fleet doesn't contain a vehicle with this %s model").formatted(model)));
            throw new NoSuchVehicleException("Fleet doesn't contain a vehicle with this %s model name".formatted(model));
        }
    }

    /**
     * Pretraga flote
     * @param make String
     * @throws NoSuchVehicleException iznimka u slucaju da vozilo s dobivenim proizvodacem-om ne postoji
     */
    @Override
    public void SearchFleetMake(String make) throws NoSuchVehicleException{
        boolean flag = false;
        for(var value : fleet){
            if (value.getMake().equalsIgnoreCase(make)) {
                //System.out.println(value);
                flag = true;
                break;
            }
        }
        if(!flag){
            logger.LoggingError(new NoSuchVehicleException(("Fleet doesn't contain a vehicle with this %s manufacturer").formatted(make)));
            throw new NoSuchVehicleException("Fleet doesn't contain a vehicle with this %s manufacturer's name".formatted(make));
        }
    }

    /**
     * Dohvacanje svih elemenata u listi kao read only
     * @return read only list
     */
    @Override
    public List<Vehicle> GetAllFleet() {
        return Collections.unmodifiableList(fleet);
    }


    /**
     * Prosljeduje dobiveni parametar klasi Logging
     * @param throwable iznimka
     */
    public void errorThrough(Throwable throwable){
        logger.LoggingError(throwable);
    }

    /**
     * Prosljeduje dobiveni parametar klasi Logging
     * @param info informacija o događaju
     */
    public void infoThrough(String info){
        logger.LoggingInfo(info);
    }

}
