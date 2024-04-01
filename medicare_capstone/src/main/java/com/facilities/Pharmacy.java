package com.facilities;

import com.healthworkers.HealthWorker;

public class Pharmacy implements Facility {
    @Override
    public void printDetails() {
        System.out.println("Pharmacy details...");
        // Print or return pharmacy-specific details
    }
   

    public void addHealthWorker(HealthWorker healthWorker) {
        // Add health worker to pharmacy
    }
}