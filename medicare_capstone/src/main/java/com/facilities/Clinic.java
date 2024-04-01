package com.facilities;

import com.healthworkers.HealthWorker;

public class Clinic implements Facility {
    @Override
    public void printDetails() {
        System.out.println("Clinic details...");
        // Print or return clinic-specific details
    }

    public void addHealthWorker(HealthWorker healthWorker) {
        // Add health worker to clinic
    }
}