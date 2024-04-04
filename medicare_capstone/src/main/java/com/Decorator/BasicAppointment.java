package com.Decorator;


public class BasicAppointment implements AppointmentsInterface {
    private String description;
   
    private double cost;

    public BasicAppointment(String description,double cost) {
        this.description = description;
        
        this.cost=cost;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public double getCost() {
        return cost;
    }
}
