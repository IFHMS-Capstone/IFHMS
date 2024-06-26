package com.healthworkers;
import java.util.List;
import java.util.Scanner;

import com.Models.Patient;
import com.Repository.Providers.DataProvider;
import com.Repository.Repository.DataRepository;


public class Nurse extends HealthWorker{
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    
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
        DataRepository repo = new DataRepository(new DataProvider());
        repo.registerPatient(patient);
        
        System.out.println("Patient registered successfully");
    }

    @Override
    void PrimaryRole() {
       
        System.out.println(".....Enter Patient Details.......");
        
        System.out.println("Enter first name:");
        String firstname = s.nextLine();
        System.out.println("Enter last name: " );
        String lastname = s.nextLine();
        System.out.println("Enter Phone number: ");
        String phone = s.nextLine();
        System.out.println("Enter age: " );
        int age = s.nextInt();

        Patient patient = new  Patient(firstname, lastname,phone,age);
        

        registerPatient(patient);
      

    }

    @Override
    void SecondaryRole() {
        System.out.println("...........REGISTERED PATIENTS.............");
        DataRepository dataRepository = new DataRepository(new DataProvider());
        List<Patient> patientList = dataRepository.getPatients();

        for(Patient patient : patientList){
            System.out.print(patient.firstName+ " "+patient.lastName + " ");
            System.out.println(patient.phoneNumber);

        }

       
    }

    @Override
    void tertiaryDetails() {
        
    }
}