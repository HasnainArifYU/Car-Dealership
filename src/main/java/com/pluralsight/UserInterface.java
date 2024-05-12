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
        init();
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Menu:");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Option 3");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected Option 1.");
                    // Add more logic here as needed
                    break;
                case 2:
                    System.out.println("You selected Option 2.");
                    // Add more logic here as needed
                    // break;
                case 3:
                    System.out.println("You selected Option 3.");
                    // Add more logic here as needed
                    break;
                case 4:
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
                System.out.println("VIN : "+vehicle.getVin()+"Year : "+vehicle.getYear()+"Make : "+vehicle.getMake()+"Model : "+vehicle.getModel()+"Vehicle type : "+vehicle.getVehicleType()+"Color :"+vehicle.getColor()+"Odometer : "+vehicle.getOdometer()+"Price : $"+vehicle.getPrice());
            }
        }

        public void processAllVehiclesRequest(){
            ArrayList<Vehicle> inventory = this.dealership.getAllVehicles();
            displayVehicles(inventory);
        }


}
