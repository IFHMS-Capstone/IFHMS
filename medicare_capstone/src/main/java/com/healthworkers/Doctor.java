package com.healthworkers;

public class Doctor implements HealthWorker{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Doctor(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void printDetails() {
        System.out.println("Doctor details...");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    void prescribeMedication() {
        System.out.println("Medication prescribed successfully");
    }
}
