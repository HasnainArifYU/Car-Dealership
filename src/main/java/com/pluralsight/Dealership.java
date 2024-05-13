package com.pluralsight;

import java.util.ArrayList;

public class Dealership {

    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public ArrayList<Vehicle> getAllVehicles(){

        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getVehicleByPrice(double min,double max) {
        ArrayList<Vehicle> carsByPrice = new ArrayList<Vehicle>();
        for (Vehicle car: inventory) {
            if (car.getPrice()>=min && car.getPrice()<=max) {
                carsByPrice.add(car);
            }
        }
        return carsByPrice;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {
        ArrayList<Vehicle> carsByMakeModel = new ArrayList<Vehicle>();
        for (Vehicle car: inventory) {
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)) {
                carsByMakeModel.add(car);
            }
        }
        return carsByMakeModel;
    }
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> carsByYear = new ArrayList<Vehicle>();
        for (Vehicle car: inventory) {
            if(car.getYear()>=min && car.getYear()<=max) {
                carsByYear.add(car);
            }
        }
        return carsByYear;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> carsByColor = new ArrayList<Vehicle>();
        for (Vehicle car: inventory) {
            if(car.getColor().equalsIgnoreCase(color)) {
                carsByColor.add(car);
            }
        }
        return carsByColor;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> carsByMileage = new ArrayList<Vehicle>();
        for (Vehicle car: inventory) {
            if(car.getOdometer()>=min && car.getOdometer()<=max) {
                carsByMileage.add(car);
            }
        }
        return carsByMileage;
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> carsByType = new ArrayList<Vehicle>();
        for (Vehicle car: inventory) {
            if(car.getVehicleType().equalsIgnoreCase(vehicleType)) {
                carsByType.add(car);
            }
        }
        return carsByType;
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }




}
