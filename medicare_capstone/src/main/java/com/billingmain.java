package com;

import java.util.Scanner;

import com.BillingCollection.Interact_Billing.Billing;
import com.Models.Invoice;
import com.Models.Patient;


public class billingmain {
    @SuppressWarnings("resource")
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        // create a patient
        System.out.println(".................ENTER PATIENT DETAILS...............");
        System.out.print("Enter Firstname:");
        String fname = s.nextLine();
        System.out.print("Enter Lastname:");
        String lname = s.nextLine();
        System.out.print("Enter phoneNumber:");
        String phone = s.nextLine();
        System.out.print("Enter age:");
        int age = s.nextInt();

        // interaction with billing system by patient
        Patient patient = new Patient(fname, lname, phone, age);
        Invoice invoice = new Invoice();

        Billing billing = new Billing(patient, invoice);
        billing.processBills();

    }

}
