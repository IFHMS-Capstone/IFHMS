package com.Repository.Providers;

import java.util.List;

import com.Models.Appointment;
import com.Models.Patient;

public interface IDataProvider {
    public List<Patient> getPatients();
    public List<Appointment> getAppointments();
    public void registerPatient(Patient patient);
    public void makeAppointment(Appointment appointment);

    
}
