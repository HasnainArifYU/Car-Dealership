package com.pluralsight;

import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() {
        String fileName = "inventory.csv";
        File file = new File(fileName);
        // Check if the file exists. If it does not, create it.
        if (!file.exists()) {
            try {
                file.createNewFile(); // This will create a new file if it does not exist
            } catch (IOException e) {
                System.out.println("An error occurred while trying to create a new file: " + e.getMessage());
                return null; // Exit the method if file creation fails
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] dealershipInfoArr =  reader.readLine().split("\\|");
            String dealershipName = dealershipInfoArr[0];
            String dealershipAddy = dealershipInfoArr[1];
            String dealershipNum = dealershipInfoArr[2];
            Dealership dealership = new Dealership(dealershipName, dealershipAddy, dealershipNum);
            while ((line = reader.readLine())!= null) {
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
        }  catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }
}
