package Main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args){
        VehicleManagerImpl vehicleManager = new VehicleManagerImpl();
        LogManager.getLogManager().reset();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Vehicle Fleet Management System");
                System.out.println("---------------------------------");
                System.out.println("""
                        1. Add a vehicle to the fleet
                        2. Search for vehicles by make or model
                        3. Print all vehicles in the fleet
                        4. Delete a vehicle from the fleet
                        5. Quit
                        Enter command:""");

                String input = scanner.next();
                String input2;
                switch (input){
                    case "1":
                        System.out.println("""
                                What type of vehicle would you like to add?
                                Enter 'car' or 'truck'
                                Enter command:""");

                        input2 = scanner.next();
                        switch (input2.toLowerCase()) {
                            case "car" -> {
                                System.out.println("Enter make: ");
                                String make = scanner.next();
                                System.out.println("Enter model: ");
                                String model = scanner.next();
                                System.out.println("Enter year: ");
                                int year = Integer.parseInt(scanner.next());
                                System.out.println("Enter color: ");
                                String color = scanner.next();
                                System.out.println("Enter VIN: ");
                                int vin = Integer.parseInt(scanner.next());
                                System.out.println("Enter fuel type: ");
                                String fuel = scanner.next();
                                System.out.println("Enter number of doors: ");
                                int numDoors = Integer.parseInt(scanner.next());
                                System.out.println("Enter body style: ");
                                String bodyStyle = scanner.next();
                                vehicleManager.AddToFleet(new Car(make, model, year, color, vin, fuel, numDoors, bodyStyle));
                            }
                            case "truck" -> {
                                System.out.println("Enter make: ");
                                String make = scanner.next();
                                System.out.println("Enter model: ");
                                String model = scanner.next();
                                System.out.println("Enter year: ");
                                int year = Integer.parseInt(scanner.next());
                                System.out.println("Enter color: ");
                                String color = scanner.next();
                                System.out.println("Enter VIN: ");
                                int vin = Integer.parseInt(scanner.next());
                                System.out.println("Enter fuel type: ");
                                String fuel = scanner.next();
                                System.out.println("Enter towing capacity: ");
                                int towingCapacity = Integer.parseInt(scanner.next());
                                vehicleManager.AddToFleet(new Truck(make, model, year, color, vin, fuel, towingCapacity));
                            }
                            default ->{
                                vehicleManager.infoThrough("Invalid command while choosing between car and truck");
                                System.out.println("Invalid command. Enter a number between 1 and 2");
                            }
                        }
                        break;
                    case "2":
                        System.out.println("""
                                How would you like to search vehicles
                                1. Search by make
                                2. Search by model
                                Enter command:""");

                        input2 = scanner.next();
                        switch (input2.toLowerCase()) {
                            case "1" -> {
                                System.out.println("Enter command: ");
                                String make = scanner.next();
                                vehicleManager.SearchFleetMake(make);
                            }
                            case "2" -> {
                                System.out.println("Enter command: ");
                                String model = scanner.next();
                                vehicleManager.SearchFleetModel(model);
                            }
                            default -> {
                                vehicleManager.infoThrough("Invalid command while searching for vehicles");
                                System.out.println("Invalid command. Please enter a number between 1 and 2.");
                            }

                        }
                    case "3":
                        for(var items : vehicleManager.GetAllFleet()){
                            System.out.println(items.toString());
                        }
                        break;
                    case "4":
                        System.out.println("Enter VIN for deletion");
                        int vin = Integer.parseInt(scanner.next());
                        vehicleManager.DeleteFromFleet(vin);
                        break;
                    case "5":
                        return;
                    default:
                        vehicleManager.infoThrough("Invalid command in menu");
                        System.out.println("Invalid command. Please enter a number between 1 and 5!");
                        break;
                }

            } catch (IllegalArgumentException | InputMismatchException | DuplicateVehicleException |
                     NoSuchVehicleException e) {
                vehicleManager.errorThrough(e);
                System.out.println("EXCEPTION: " + e.getMessage());
            }
        }
    }
}