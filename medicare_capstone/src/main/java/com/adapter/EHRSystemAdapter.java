package com.adapter;

public class EHRSystemAdapter implements EHRSystem {
    private LegacyEHRSystem legacyEHRSystem;
    
    public EHRSystemAdapter(LegacyEHRSystem legacyEHRSystem) {
        this.legacyEHRSystem = legacyEHRSystem;
    }

    @Override
    public void retrievePatientData() {
        legacyEHRSystem.getPatientDetails();
    }
}
