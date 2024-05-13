package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;


    public UserInterface() {
    }

    private void init() {
        DealershipFileManager Manager = new DealershipFileManager();
        this.dealership = Manager.getDealership();
    }

    public void display() {
        this.init();
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Menu:");
            System.out.println("1. Find Vehicles By Price Range ");
            System.out.println("2. Find Vehicles By Make/Model ");
            System.out.println("3. Find Vehicles By Years ");
            System.out.println("4. Find Vehicles By Color ");
            System.out.println("5. Find Vehicles By Mileage Range ");
            System.out.println("6. Find Vehicles By Type ");
            System.out.println("7. LIST ALL VEHICLES ");
            System.out.println("8. Add a Vehicle ");
            System.out.println("9. Remove a Vehicle ");
            System.out.println("99. QUIT ");


            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    System.out.println("You selected Option 2.");
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    System.out.println("You selected Option 3.");
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByTypeRequest();
                    break;

                case 7:
                    System.out.println("You selected Option 7.");
                    processAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehiclesRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 99:
                    System.out.println("Exiting...");
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println("VIN: " + vehicle.getVin() + "  " + "Year: " + vehicle.getYear() + "  " + "Make: " + vehicle.getMake() + "  " + "Model: " + vehicle.getModel() + "  " + "Vehicle type: " + vehicle.getVehicleType() + "  " + "Color: " + vehicle.getColor() + "  " + "Odometer: " + vehicle.getOdometer() + "  " + "Price: $" + vehicle.getPrice());
        }
    }

    public void processAllVehiclesRequest() {
        ArrayList<Vehicle> inventory = this.dealership.getAllVehicles();
        displayVehicles(inventory);
    }

    public void processGetByPriceRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter the Minimum Price ");
        double min = s.nextDouble();
        System.out.println("Now Please Enter the Maximum Price ");
        double max = s.nextDouble();
        ArrayList<Vehicle> carsByPrice = dealership.getVehicleByPrice(min, max);
        for (Vehicle vehicle : carsByPrice) {
            System.out.println("VIN: " + vehicle.getVin() + "  " + "Year: " + vehicle.getYear() + "  " + "Make: " + vehicle.getMake() + "  " + "Model: " + vehicle.getModel() + "  " + "Vehicle type: " + vehicle.getVehicleType() + "  " + "Color: " + vehicle.getColor() + "  " + "Odometer: " + vehicle.getOdometer() + "  " + "Price: $" + vehicle.getPrice());
        }
    }

    public void processGetByMakeModelRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter the Make ");
        String make = s.nextLine();
        System.out.println("Please Enter the Model ");
        String model = s.nextLine();
        ArrayList<Vehicle> carsByMakeModel = dealership.getVehicleByMakeModel(make, model);
        for (Vehicle vehicle : carsByMakeModel) {
            System.out.println("VIN: " + vehicle.getVin() + "  " + "Year: " + vehicle.getYear() + "  " + "Make: " + vehicle.getMake() + "  " + "Model: " + vehicle.getModel() + "  " + "Vehicle type: " + vehicle.getVehicleType() + "  " + "Color: " + vehicle.getColor() + "  " + "Odometer: " + vehicle.getOdometer() + "  " + "Price: $" + vehicle.getPrice());
        }
    }

    public void processGetByYearRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter the Year Range ");
        System.out.println("Start Year : ");
        int year1 = s.nextInt();
        System.out.println("End Year : ");
        int year2 = s.nextInt();

        ArrayList<Vehicle> carsByYear = dealership.getVehiclesByYear(year1, year2);
        for (Vehicle vehicle : carsByYear) {
            System.out.println("VIN: " + vehicle.getVin() + "  " + "Year: " + vehicle.getYear() + "  " + "Make: " + vehicle.getMake() + "  " + "Model: " + vehicle.getModel() + "  " + "Vehicle type: " + vehicle.getVehicleType() + "  " + "Color: " + vehicle.getColor() + "  " + "Odometer: " + vehicle.getOdometer() + "  " + "Price: $" + vehicle.getPrice());
        }
    }

    public void processGetByColorRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter the Color ");
        String color = s.nextLine();
        ArrayList<Vehicle> carsByColor = dealership.getVehiclesByColor(color);
        for (Vehicle vehicle : carsByColor) {
            System.out.println("VIN: " + vehicle.getVin() + "  " + "Year: " + vehicle.getYear() + "  " + "Make: " + vehicle.getMake() + "  " + "Model: " + vehicle.getModel() + "  " + "Vehicle type: " + vehicle.getVehicleType() + "  " + "Color: " + vehicle.getColor() + "  " + "Odometer: " + vehicle.getOdometer() + "  " + "Price: $" + vehicle.getPrice());
        }
    }

    public void processGetByMileageRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter the Mileage Range ");
        System.out.println("Minimum miles : ");
        int miles1 = s.nextInt();
        System.out.println("Maximum miles : ");
        int miles2 = s.nextInt();

        ArrayList<Vehicle> carsbyMiles = dealership.getVehiclesByMileage(miles1, miles2);
        for (Vehicle vehicle : carsbyMiles) {
            System.out.println("VIN: " + vehicle.getVin() + "  " + "Year: " + vehicle.getYear() + "  " + "Make: " + vehicle.getMake() + "  " + "Model: " + vehicle.getModel() + "  " + "Vehicle type: " + vehicle.getVehicleType() + "  " + "Color: " + vehicle.getColor() + "  " + "Odometer: " + vehicle.getOdometer() + "  " + "Price: $" + vehicle.getPrice());
        }
    }

    public void processGetByTypeRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter the Vehicle type ");
        String type = s.nextLine();
        ArrayList<Vehicle> carsByType = dealership.getVehiclesByType(type);
        for (Vehicle vehicle : carsByType) {
            System.out.println("VIN: " + vehicle.getVin() + "  " + "Year: " + vehicle.getYear() + "  " + "Make: " + vehicle.getMake() + "  " + "Model: " + vehicle.getModel() + "  " + "Vehicle type: " + vehicle.getVehicleType() + "  " + "Color: " + vehicle.getColor() + "  " + "Odometer: " + vehicle.getOdometer() + "  " + "Price: $" + vehicle.getPrice());
        }
    }
    public void processAddVehiclesRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter the Vehicle VIN");
        int VIN = s.nextInt();
        System.out.println("Please Enter the Vehicle Year");
        int Year = s.nextInt();
        s.nextLine();
        System.out.println("Please Enter the Vehicle Make");
        String make = s.nextLine();
        System.out.println("Please Enter the Vehicle Model");
        String model = s.nextLine();
        System.out.println("Please Enter the Vehicle Type");
        String type = s.nextLine();
        System.out.println("Please Enter the Vehicle Color");
        String color = s.nextLine();
        System.out.println("Please Enter the Vehicle Odometer Reading ");
        int odo = s.nextInt();
        System.out.println("Finally, enter the price of the vehicle ");
        double price = s.nextDouble();

        Vehicle vehicle = new Vehicle(VIN, Year, make, model, type, color, odo, price);
        dealership.addVehicle(vehicle);



    }
    public void processRemoveVehicleRequest() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Enter the VIN of the Vehicle to remove : ");
        int VIN = s.nextInt();
        ArrayList<Vehicle> getVehicles = dealership.getAllVehicles();
        for (Vehicle vehicle : getVehicles) {
            if (vehicle.getVin()==VIN) {
                dealership.removeVehicle(vehicle);
                break;
            }
        }

    }
}






