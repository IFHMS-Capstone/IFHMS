package com.Decorator;


import com.Models.Appointment;
import com.Repository.Providers.DataProvider;
import com.Repository.Repository.DataRepository;

import java.util.Scanner;

public class AppointmentEntry {
    Scanner s = new Scanner(System.in);
    int appointmenttype;

    
    public void displayAppointment(){
        System.out.println("...........SELECT APPOINTMENT PACKAGE.......... ");
        System.out.println("1.Basic appointment ");
        System.out.println("2.Specilist appointment");
        System.out.println("Enter option:");
        appointmenttype= s.nextInt();

        
        if(appointmenttype==1){
            DataRepository dataRepository = new DataRepository(new DataProvider());
            Appointment appointment = new Appointment("John Doe","Basic appointment");
            dataRepository.makeAppointment(appointment);

            AppointmentsInterface basicAppointment = new BasicAppointment("Patient Checkup", 10000);
            System.out.println("You have booked a General appointment at Ugx."+ basicAppointment.getCost());
    
        }else if(appointmenttype==2){
            DataRepository dataRepository = new DataRepository(new DataProvider());
            Appointment appointment = new Appointment("John Doe","specialist appointment");
            dataRepository.makeAppointment(appointment);

            AppointmentsInterface basicAppointment = new BasicAppointment("Patient Checkup", 10000);
            AppointmentsInterface appointmentWithSpecialist = new SpecialConsulation(basicAppointment);
            System.out.println("You have booked a Specialist appointment at Ugx.:"+ appointmentWithSpecialist.getCost());
    
        }

    }
    
    
           
    
}
