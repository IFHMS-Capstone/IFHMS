package com.BillingCollection.Interact_Billing;

import com.Models.Invoice;
import com.Models.Patient;
import com.BillingCollection.Billingfacade.IHFMSFacade;
import com.BillingCollection.BillingsAdapter.BillingAdapter;
import com.BillingCollection.BillingsAdapter.BillingSystemAdapter;
import com.BillingCollection.external.ExternalBillingSystem;

public class Billing {
    private Patient patient;
    private Invoice invoice;

    public Billing(Patient patient, Invoice invoice){
        this.patient = patient;
        this.invoice=invoice;

    }

    public void processBills(){
        invoice.setPatient(patient.firstName +" "+ patient.lastName);
        invoice.setAmount(20000);
        ExternalBillingSystem externalBilling = new ExternalBillingSystem();
        BillingSystemAdapter billingSystemAdapter = new BillingAdapter(externalBilling);
        IHFMSFacade billingFacade = new IHFMSFacade(billingSystemAdapter);

        billingFacade.processPatientInvoice(patient, invoice);
    }
    
}
