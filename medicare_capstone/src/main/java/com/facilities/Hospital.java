package com.facilities;
import java.util.ArrayList;
import java.util.List;

import com.healthworkers.HealthWorker;



public class Hospital implements Facility {
    public String Name;
    public String Address;
    private List<HealthWorker> healthWorkers = new ArrayList<HealthWorker>();

    public Hospital(String Name, String Address) {
        this.Name = Name;
        this.Address = Address;
    }

    @Override
    public void printDetails() {
        System.out.println("........Welcome to hospital....");
        System.out.println("1.Patient");
        System.out.println("2.Healthworker");
        // Print or return hospital-specific details
    }

    public void addHealthWorker(HealthWorker healthWorker) {
        healthWorkers.add(healthWorker);
        for (HealthWorker hw : healthWorkers) {
            hw.printDetails();
        }
    }
}