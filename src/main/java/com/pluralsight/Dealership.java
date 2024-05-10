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
        return null;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByYear(String min, String max) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        return null;
    }
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }
    public void removeVehicle(Vehicle vehicle){
        //inventory.remove(vehicle);
    }




}
