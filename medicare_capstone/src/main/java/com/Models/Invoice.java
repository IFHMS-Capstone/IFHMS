package com.Models;



public class Invoice {
    
    private String patientName;
    private double amount;
    

   
    public double getAmount() {
        return amount;
    }

   

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPatientName() {
        return patientName;
    }

   

    public void setPatient(String name) {
        this.patientName = name;
    }

    
}