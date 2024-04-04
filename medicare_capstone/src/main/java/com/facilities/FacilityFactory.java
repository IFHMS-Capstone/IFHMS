package com.facilities;
public class FacilityFactory {

    public static Facility createFacility(int facilityType, String name, String address) {
        switch (facilityType) {
            case 1:
                return new Hospital(name, address);
            case 2:
                return new Clinic();
            case 3:
                return new Pharmacy();
            default:
                return null;
        }
    }
}