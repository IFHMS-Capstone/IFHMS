package com.BillingCollection.external;

public class ExternalBillingSystem {

    public ExternalBillingSystem() {
        // Constructor logic if needed
    }

    // public void createInvoice(String customerID, double amount)
    public void createInvoice(String reason, double amount) {
        // Dummy implementation for creating an invoice in the external system
        System.out.println("Created invoice in external system for  " + reason + " with amount " + amount);
        // You can add more logic here to simulate interaction with an external billing
        // system
    }
}
