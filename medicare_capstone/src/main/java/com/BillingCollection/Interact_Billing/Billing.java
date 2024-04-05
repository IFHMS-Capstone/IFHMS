package com.BillingCollection.Interact_Billing;

import com.Models.Invoice;
import com.Models.Patient;

import java.util.Scanner;

import com.BillingCollection.Billingfacade.IHFMSFacade;
import com.BillingCollection.BillingsAdapter.BillingAdapter;
import com.BillingCollection.BillingsAdapter.BillingSystemAdapter;
import com.BillingCollection.external.ExternalBillingSystem;

public class Billing {
    Scanner s = new Scanner(System.in);
    private Patient patient;
    private Invoice invoice;

    public Billing(Patient patient, Invoice invoice) {
        this.patient = patient;
        this.invoice = invoice;
    }

    public void processBills() {
        invoice.setPatient(patient.firstName + " " + patient.lastName);
        System.out.println("Enter Reason of payment:");
        String reason = s.nextLine();

        System.out.println("Enter amount:");

        int amount = s.nextInt();
        invoice.setAmount(amount);
        invoice.setReason(reason);
        ExternalBillingSystem externalBilling = new ExternalBillingSystem();
        BillingSystemAdapter billingSystemAdapter = new BillingAdapter(externalBilling);
        IHFMSFacade billingFacade = new IHFMSFacade(billingSystemAdapter);

        billingFacade.processPatientInvoice(patient, invoice);
    }

}
