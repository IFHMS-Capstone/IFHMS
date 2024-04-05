package com.healthworkers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoctorIT {
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemOutput() {
        // Restore original System.out
        System.setOut(originalSystemOut);
    }

    @Test
    public void testPrimaryRole_ShowsAssignments() {
        Doctor doctor = new Doctor("Dr. Smith", "456 Elm St", "1234567890", "dr.smith@example.com");

        // Execute the primary role, which should show assignments
        doctor.PrimaryRole();

        // Verify that the output contains the expected message
        String output = getOutput();
        assertTrue(output.contains("All available assignments seen"));
    }

    @Test
    public void testPrescribeMedication_PrintsSuccess() {
        Doctor doctor = new Doctor("Dr. Smith", "456 Elm St", "1234567890", "dr.smith@example.com");

        // Execute the prescribeMedication method
        doctor.prescribeMedication();

        // Verify that the output contains the success message
        String output = getOutput();
        assertTrue(output.contains("Medication prescribed successfully"));
    }

    // Additional tests for SecondaryRole and tertiaryDetails can be added once implemented
}