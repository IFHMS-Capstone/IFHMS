package com.facilities;
public class FacilityFactory {

    public static Facility createFacility(int facilityType, String name, String address) {
        switch (facilityType) {
            case 1:
                return new Pharmacy();
            case 2:
                return new Hospital(name, address);
            case 3:
                return new Clinic();
            default:
                return null;
        }
    }
}