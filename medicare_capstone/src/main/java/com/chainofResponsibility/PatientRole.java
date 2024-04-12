package com.chainofResponsibility;

import java.util.Scanner;
import com.BillingCollection.Interact_Billing.Billing;
import com.Decorator.AppointmentEntry;

import com.Models.Invoice;
import com.Models.Patient;
import com.facilities.Facility;
import com.facilities.FacilityFactory;


public class PatientRole implements IRole {
    Scanner scanner = new Scanner(System.in);
    private IRole role;

    @Override
    public void setnextRole(IRole role) {
        this.role = role;

    }

    @Override
    public void execute(String myrole) {
        if (myrole.equals("patient")) {

            System.out.println("SELECT FACILITY OF INTEREST ");
            System.out.println("1.Hospital ");
            System.out.println("2.Clinic");
            System.out.println("3.Pharmacy");

            // selecting a preferred type of facility
            System.out.println("Enter facility type:.. ");
            Integer facilityType = scanner.nextInt();

            Facility facility = FacilityFactory.createFacility(facilityType, "Mulago", "Kampala");
            if (facility != null) {

                Patient patient = new Patient(null, null, null, 23);
                while (true) {
                    patient.displayPatientRoles();
                    Integer patientTask = scanner.nextInt();

                    if (patientTask == 1) {
                        // make appointment
                        int i = 0;
                        while (i < 2) {
                            AppointmentEntry appointmentEntry = new AppointmentEntry();
                            appointmentEntry.displayAppointment();

                            i++;

                        }

                    } else if (patientTask == 2) {
                        Invoice invoice = new Invoice();
                        Billing billing = new Billing(patient, invoice);
                        billing.processBills();

                        break;

                    }
                }

            } else {
                System.out.println("Invalid facility type");
            }

        } else {
            this.role.execute(myrole);
        }
    }

}
