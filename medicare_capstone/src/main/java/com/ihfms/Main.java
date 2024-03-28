package com.ihfms;

public class Main {
     public static void main(String[] args) {
        // Factory Method Pattern
        DocumentFactory documentFactory = new ConcreteDocumentFactory();
        Document invoice = documentFactory.createDocument("INVOICE");
        invoice.displayInfo();

        // Singleton Pattern
        ConnectionManager connectionManager = ConnectionManager.getInstance();
        connectionManager.connect();

        // Adapter Pattern
        LegacyEHRSystem legacyEHRSystem = new LegacyEHRSystem();
        EHRSystem ehrSystem = new EHRSystemAdapter(legacyEHRSystem);
        ehrSystem.retrievePatientData();

        // Facade Pattern
        PatientEncounterFacade patientEncounterFacade = new PatientEncounterFacade(ehrSystem, documentFactory);
        patientEncounterFacade.handlePatientEncounter();

        // Decorator Pattern
        Message message = new SimpleMessage("Patient records updated.");
        Message encryptedMessage = new EncryptionDecorator(message);
        encryptedMessage.send();

        // Observer Pattern
        EHRSystemSubject ehrSystemSubject = new EHRSystemSubject();
        Observer billingManager = new BillingManager();
        ehrSystemSubject.addObserver(billingManager);
        ehrSystemSubject.setPatientData("New diagnosis added.");

        // Strategy Pattern
        PaymentContext paymentContext = new PaymentContext();
        paymentContext.setPaymentStrategy(new CreditCardPaymentStrategy());
        paymentContext.executePayment(150.0);

        // State Pattern
        PatientEncounter patientEncounter = new PatientEncounter(new AdmittedState());
        patientEncounter.handleState();
        patientEncounter.setState(new InTreatmentState());
        patientEncounter.handleState();
        patientEncounter.setState(new DischargedState());
        patientEncounter.handleState();
    }
}