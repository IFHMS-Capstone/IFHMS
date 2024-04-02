package com.facilities;

import com.healthworkers.HealthWorker;

public class Clinic implements Facility {
    @Override
    public void printDetails() {
        System.out.println("........Welcome to Clinic....");
        System.out.println("1.Patient");
        System.out.println("2.Healthworker");
    }

    public void addHealthWorker(HealthWorker healthWorker) {
        // Add health worker to clinic
    }
}