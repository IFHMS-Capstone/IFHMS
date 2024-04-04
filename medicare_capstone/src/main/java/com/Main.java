package com;

import java.util.Scanner;


package com.ihfms;

import java.util.Scanner;

import com.observer.ConsoleMessageNotifier;
import com.observer.MessageNotifier;
import com.observer.MessageService;
import com.observer.MessagingSystem;

import com.BillingCollection.Interact_Billing.Billing;
import com.Decorator.AppointmentEntry;

import com.Models.Invoice;
import com.Models.Patient;
import com.facilities.Facility;
import com.facilities.FacilityFactory;

import com.healthworkers.HealthWorker;
import com.healthworkers.HealthWorkerFactory;

public class App {
    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println(".........WELCOME TO IHFMS........... ");
        System.out.println("SELECT FACILITY OF INTEREST ");
        System.out.println("1.Hospital ");
        System.out.println("2.Clinic");
        System.out.println("3.Pharmacy");

        // selecting a preferred type of facility
        System.out.println("Enter facility type:.. ");
        Integer facilityType = scanner.nextInt();

        Facility facility = FacilityFactory.createFacility(facilityType, "Mulago", "Kampala");
        if (facility != null) {
            facility.printDetails();
            // select role in this facility either as patient or healthy worker
            System.out.println("Select role: ");
            Integer roleType = scanner.nextInt();

            if (roleType == 1) {
                Patient patient = new Patient(null, null, null, 23);
                HERE: patient.displayPatientRoles();
                Integer patientTask = scanner.nextInt();
                while (true) {

                    if (patientTask == 1) {
                        // make appointment
                        AppointmentEntry appointmentEntry = new AppointmentEntry();
                        appointmentEntry.displayAppointment();

                        System.out.println("Do you want to go back to the main menu? (yes/no)");
                        String response = scanner.next();
                        if (response.equalsIgnoreCase("yes")) {
                            break; // Breaks the loop and goes back to the main menu
                        }

                    } else if (patientTask == 2) {
                        Invoice invoice = new Invoice();
                        Billing billing = new Billing(patient, invoice);
                        billing.processBills();

                    }
                }

            } else if (roleType == 2) {
                // if healthyworker select typr of healthyworker
                System.out.println("..............WHAT KIND OF HEALTH WORKER ARE YOU ");
                System.out.println("1.Doctor ");
                System.out.println("2.Nurse");
                Integer healthWorkerType = scanner.nextInt();

                HealthWorker healthyWorker = HealthWorkerFactory.getHealthyWorker(healthWorkerType);
                healthyWorker.templateMethod();

            }

        } else {
            System.out.println("Invalid facility type");
        }
    }
}

package com.ihfms;

import java.util.Scanner;

import com.observer.ConsoleMessageNotifier;
import com.observer.MessageNotifier;
import com.observer.MessageService;
import com.observer.MessagingSystem;

public class Main {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        MessageNotifier notifier = new ConsoleMessageNotifier();
        Scanner scanner = new Scanner(System.in);

        MessagingSystem messagingSystem = new MessagingSystem(messageService, notifier, scanner);
        messagingSystem.start();

        scanner.close();
    }
}