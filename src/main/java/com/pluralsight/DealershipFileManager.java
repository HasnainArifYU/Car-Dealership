package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership() {
        String fileName = "dealership.csv";
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while trying to create a new file: " + e.getMessage());
                return null;
            }
        }
        Dealership dealership = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] dealershipInfoArr = reader.readLine().split("\\|");
            String dealershipName = dealershipInfoArr[0];
            String dealershipAddy = dealershipInfoArr[1];
            String dealershipNum = dealershipInfoArr[2];
            dealership = new Dealership(dealershipName, dealershipAddy, dealershipNum);
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 8) {
                    continue;
                }
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);
                String make = data[2].trim();
                String model = data[3].trim();
                String type = data[4].trim();
                String color = data[5].trim();
                int odo = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odo, price);
                dealership.addVehicle(vehicle);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return dealership;

    }
    public static void saveDealership(Dealership dealership) {
        ArrayList<Vehicle> updatedList = dealership.getAllVehicles();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv"))) {
            for (Vehicle vehicle : updatedList) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()+ "|" + vehicle.getVehicleType()+ "|" + vehicle.getColor()+ "|" + vehicle.getOdometer()+ "|" + vehicle.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
