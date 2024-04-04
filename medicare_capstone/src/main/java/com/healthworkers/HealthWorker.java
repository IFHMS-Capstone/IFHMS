package com.healthworkers;

public abstract class HealthWorker {

    public void templateMethod(){
        PrimaryRole();
        SecondaryRole();
        tertiaryDetails();
    }
    public abstract void  printDetails();
    abstract void  PrimaryRole();
    abstract void  SecondaryRole();
    abstract void  tertiaryDetails();

}
