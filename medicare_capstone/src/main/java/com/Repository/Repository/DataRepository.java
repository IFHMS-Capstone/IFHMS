package com.Repository.Repository;

import com.Models.Appointment;
import com.Models.Patient;
import com.Repository.Providers.IDataProvider;
import java.util.*;

public class DataRepository {
    private static IDataProvider provider;

    public DataRepository(IDataProvider providee) {
        provider = providee;

    }

    public List<Patient> getPatients() {
        return provider.getPatients();

    };

    public void registerPatient(Patient patient) {
        provider.registerPatient(patient);

    };

    public void makeAppointment(Appointment appointment) {
        provider.makeAppointment(appointment);

    };

    public List<Appointment> getAppointments() {
        return provider.getAppointments();

    };
}
