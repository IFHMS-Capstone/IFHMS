package com.healthworkers;



public class HealthWorkerFactory {

     public static HealthWorker getHealthyWorker (int HealthyWorkerType ) {
        switch (HealthyWorkerType) {
            case 1:
                return new Doctor("david", "kamapala", "0771245677", "mk@gmail.com");
            case 2:
                return new Nurse("Jane", "kamapala", "0771213799", "jane@gmail.com");
            
            default:
                return null;
        }
    }
    
}
