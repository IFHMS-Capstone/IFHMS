package com.Repository.Providers;

import com.Models.Appointment;
import com.Models.Patient;
import java.util.*;

public class DataProvider implements IDataProvider {
    private static List<Patient> patientsList = new ArrayList<Patient>();
    private static List<Appointment> AppointmentList = new ArrayList<Appointment>();

    public DataProvider() {
        AppointmentList.add(new Appointment("Peter Kyeyune", "Basic"));
        AppointmentList.add(new Appointment("John Doe", "Special Consultation"));
        AppointmentList.add(new Appointment("Jane Doe", "Basic"));
        AppointmentList.add(new Appointment("Alice Doe", "Special Consultation"));
    }

    @Override
    public List<Patient> getPatients() {
        return patientsList;

    }

    @Override
    public void registerPatient(Patient patient) {
        patientsList.add(patient);

    }

    @Override
    public void makeAppointment(Appointment appointment) {
        AppointmentList.add(appointment);

    }

    @Override
    public List<Appointment> getAppointments() {
        return AppointmentList;
    }

}
