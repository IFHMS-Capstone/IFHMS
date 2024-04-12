package com.Models;

public class Appointment {
    
    private String patientName;
    
    private String appointmentType;
    
    public Appointment(String patientName, String appointmentType) {
        this.patientName = patientName;
        this.appointmentType = appointmentType;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getAppointmentType() {
        return appointmentType;
    }
    


    
    
    
}
