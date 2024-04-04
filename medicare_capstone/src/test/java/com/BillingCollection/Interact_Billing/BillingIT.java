package com.BillingCollection.Interact_Billing;

import com.Models.Patient;
import com.Models.Invoice;
import com.BillingCollection.external.ExternalBillingSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

public class BillingIT {
    private ExternalBillingSystem externalBilling;
    private Patient patient;
    private Invoice invoice;
    private final InputStream originalSystemIn = System.in;
    private ByteArrayInputStream testIn;

    @BeforeEach
    void setUp() {
        // Mock the external billing system
        externalBilling = Mockito.mock(ExternalBillingSystem.class);

        // Set up test data
        patient = new Patient("John", "Doe", "1234567890", 30);
        invoice = new Invoice();

        // Simulate user input for the billing process
        String input = "Medical services\n1000\n";
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    @AfterEach
    void restoreSystemIn() {
        // Restore original System.in
        System.setIn(originalSystemIn);
    }

    @Test
    void testProcessBills() {
        // Create a Billing instance with the test data
        Billing billing = new Billing(patient, invoice);

        // Execute the billing process
        billing.processBills();

        // Verify that the invoice is set correctly
        Assertions.assertEquals("John Doe", invoice.getPatientName());
        Assertions.assertEquals(1000.0, invoice.getAmount());
        Assertions.assertEquals("Medical services", invoice.getReason());

        // Verify that the external billing system was called with the correct parameters
        verify(externalBilling).createInvoice(invoice.getReason(), invoice.getAmount());
    }
}