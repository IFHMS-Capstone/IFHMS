package com.Repository.Providers;

import com.Models.Appointment;
import com.Models.Patient;
import java.util.*;

public class DataProvider implements IDataProvider {
    private static List<Patient> patientsList = new ArrayList<Patient>();
    private static List<Appointment> AppointmentList = new ArrayList<Appointment>();

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
