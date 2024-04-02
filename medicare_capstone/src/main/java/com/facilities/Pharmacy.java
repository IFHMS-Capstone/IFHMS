package com.facilities;

import com.healthworkers.HealthWorker;

public class Pharmacy implements Facility {
    @Override
    public void printDetails() {
       
        System.out.println("........Welcome to Pharmacy....");
        System.out.println("1.Patient");
        System.out.println("2.Healthworker");
        // Print or return pharmacy-specific details
    }
   

    public void addHealthWorker(HealthWorker healthWorker) {
        // Add health worker to pharmacy
    }
}