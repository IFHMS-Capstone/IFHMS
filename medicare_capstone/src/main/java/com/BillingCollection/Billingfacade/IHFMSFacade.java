package com.BillingCollection.Billingfacade;

import com.BillingCollection.BillingsAdapter.BillingSystemAdapter;
import com.Models.Invoice;
import com.Models.Patient;

public class IHFMSFacade {
    private BillingSystemAdapter billingAdapter;

    public IHFMSFacade(BillingSystemAdapter billingAdapter) {
        this.billingAdapter = billingAdapter;
    }

    public void processPatientInvoice(Patient patient, Invoice invoice) {
        billingAdapter.processInvoice(invoice);
        // Additional logic to notify the patient or update the system state
    }
}
