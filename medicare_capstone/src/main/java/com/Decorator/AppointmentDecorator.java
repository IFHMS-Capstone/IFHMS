package com.Decorator;



public abstract class AppointmentDecorator implements AppointmentsInterface {

    protected AppointmentsInterface appointment;

    public AppointmentDecorator(AppointmentsInterface decoratee){
        this.appointment=decoratee;

    }

    @Override
    public String getDescription() {
        return appointment.getDescription();
    }

    

    @Override
    public double getCost() {
        
        return appointment.getCost();
    }
}
    

