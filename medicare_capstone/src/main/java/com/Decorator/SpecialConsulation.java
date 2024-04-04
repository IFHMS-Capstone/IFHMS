package com.Decorator;

public class SpecialConsulation extends AppointmentDecorator {

     
        public SpecialConsulation(AppointmentsInterface appointment) {
            super(appointment);
        }
    
        @Override
        public double getCost() {
            return appointment.getCost() + 10000; // Adding $50 for specialist consultation
        }
    }
    

