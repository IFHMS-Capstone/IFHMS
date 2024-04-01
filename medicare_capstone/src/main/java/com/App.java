package com;

import java.util.Scanner;

import com.Models.Patient;
import com.facilities.Facility;
import com.facilities.FacilityFactory;
import com.healthworkers.Doctor;
import com.healthworkers.Nurse;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter facility type: ");
        Integer facilityType = scanner.nextInt();

        Facility facility = FacilityFactory.createFacility(facilityType, "Mulago", "Kampala");
        if (facility != null) {
            facility.printDetails();
            Nurse jen = new Nurse("Jeniffer", "Muk", "77777", "456789456");
            facility.addHealthWorker(jen);
            facility.addHealthWorker(new Doctor("Jjumba", "Kikoni", "045245245", "jjumba@jjumba"));
            jen.registerPatient(new Patient("John", "Doe", "123456789", 25));
        } else {
            System.out.println("Invalid facility type");
        }
    }
}