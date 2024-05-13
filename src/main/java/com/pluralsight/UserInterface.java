package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
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
                    prcocessGetByMakeModelRequest();
                    break;
                case 3:
                    System.out.println("You selected Option 3.");
                    break;
                case 4:

                case 5:

                case 6:

                case 7:
                    System.out.println("You selected Option 7.");
                    processAllVehiclesRequest();
                    break;
                case 8:

                case 9:

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
        private void displayVehicles(ArrayList<Vehicle> vehicles){
            for (Vehicle vehicle: vehicles) {
                System.out.println("VIN: "+vehicle.getVin()+"  "+"Year: "+vehicle.getYear()+"  "+"Make: "+vehicle.getMake()+"  "+"Model: "+vehicle.getModel()+"  "+"Vehicle type: "+vehicle.getVehicleType()+"  "+"Color: "+vehicle.getColor()+"  "+"Odometer: "+vehicle.getOdometer()+"  "+"Price: $"+vehicle.getPrice());
            }
        }

        public void processAllVehiclesRequest(){
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
            for (Vehicle vehicle: carsByPrice){
                System.out.println("VIN: "+vehicle.getVin()+"  "+"Year: "+vehicle.getYear()+"  "+"Make: "+vehicle.getMake()+"  "+"Model: "+vehicle.getModel()+"  "+"Vehicle type: "+vehicle.getVehicleType()+"  "+"Color: "+vehicle.getColor()+"  "+"Odometer: "+vehicle.getOdometer()+"  "+"Price: $"+vehicle.getPrice());
            }
        }

        public void prcocessGetByMakeModelRequest() {
            Scanner s = new Scanner(System.in);
            System.out.println("Please Enter the Make ");
            String make = s.nextLine();
            System.out.println("Please Enter the Model ");
            String model = s.nextLine();
            ArrayList<Vehicle> carsByPrice = dealership.getVehicleByMakeModel(make, model);
            for (Vehicle vehicle: carsByPrice){
                System.out.println("VIN: "+vehicle.getVin()+"  "+"Year: "+vehicle.getYear()+"  "+"Make: "+vehicle.getMake()+"  "+"Model: "+vehicle.getModel()+"  "+"Vehicle type: "+vehicle.getVehicleType()+"  "+"Color: "+vehicle.getColor()+"  "+"Odometer: "+vehicle.getOdometer()+"  "+"Price: $"+vehicle.getPrice());
            }
        }
        }



