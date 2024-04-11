package com;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.Authentication.*;
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

    // Create scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    System.out.println(".........WELCOME TO IHFMS........... ");

    List<User> users = Arrays.asList(
            new User("doctor44", "iamdoc99@", "health worker"),
            new User("patient", "pass33$", "patient"));

    // Prompt for username
    System.out.println("Enter username: ");
    String username = scanner.nextLine();

    // Prompt for password
    System.out.println("Enter password: ");
    String password = scanner.nextLine();

    // Prompt for role
    System.out.println("Enter role(patient/health worker): ");
    String role = scanner.nextLine();

    // Authenticate User
    // Initialize the authentication strategy
    AuthenticationStrategy authStrategy = new RoleBasedAuthenticationStrategy(users);
    User authenticatedUser = authStrategy.authenticate(username, password, role);

    if (authenticatedUser != null) {
        System.out.println("Authentication successful!! Welcome " + username);

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

            new MessagingMain();
            scanner.close();

        } else {
            System.out.println("Authentication failed. Invalid credentials or role.");
        }
        scanner.close();
    } 
}
