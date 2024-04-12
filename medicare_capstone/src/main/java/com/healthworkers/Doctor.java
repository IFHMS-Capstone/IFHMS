package com.healthworkers;

import java.util.List;

import com.Repository.Providers.DataProvider;
import com.Repository.Repository.DataRepository;
import com.Models.Appointment;

public class Doctor extends HealthWorker {
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

    @Override
    void PrimaryRole() {
        System.out.println("...........YOUR APPOINTMENTS .............");
        DataRepository dataRepository = new DataRepository(new DataProvider());
        List<Appointment> appointmenttList = dataRepository.getAppointments();

        for (Appointment appoint : appointmenttList) {
            System.out.print(appoint.getPatientName() + " :");
            System.out.println(appoint.getAppointmentType());

        }
    }

    @Override
    void SecondaryRole() {

    }

    @Override
    void tertiaryDetails() {

    }
}
