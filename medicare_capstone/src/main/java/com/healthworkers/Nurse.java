package com.healthworkers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Models.Patient;


public class Nurse extends HealthWorker{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    public static List<Patient> patients = new ArrayList<Patient>();
    Scanner s = new Scanner(System.in);
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

    @Override
    void PrimaryRole() {
       
        System.out.println(".....Enter PatientDetails.......");
        
        System.out.println("Enter First name:");
        String firstname = s.nextLine();
        System.out.println("Enter last name: " );
        String lastname = s.nextLine();
        System.out.println("Enter PhoneNumber: ");
        String phone = s.nextLine();
        System.out.println("Enter age: " );
        int age = s.nextInt();

        Patient patient = new  Patient(firstname, lastname,phone,age);

        registerPatient(patient);
      

    }

    @Override
    void SecondaryRole() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SecondaryRole'");
    }

    @Override
    void tertiaryDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tertiaryDetails'");
    }
}