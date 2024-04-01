package com.healthworkers;
import java.util.ArrayList;
import java.util.List;

import com.Models.Patient;


public class Nurse implements HealthWorker{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private List<Patient> patients = new ArrayList<Patient>();
    public Nurse(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void printDetails() {
        System.out.println("Nurse details...");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Email: " + email);
    }

    public void registerPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient registered successfully");
    }
}