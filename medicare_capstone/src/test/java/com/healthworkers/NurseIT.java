package com.healthworkers;

import com.Models.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NurseIT {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        // Restore original System.in and System.out
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
        // Clear the list of patients after each test
        Nurse.patients.clear();
    }

    @Test
    public void testPrimaryRole_RegistersPatient() {
        // Simulate user input for patient registration
        String input = "John\nDoe\n1234567890\n30\n";
        provideInput(input);

        Nurse nurse = new Nurse("Jane", "123 Main St", "9876543210", "jane@example.com");

        // Execute the primary role, which should register a patient
        nurse.PrimaryRole();

        // Verify that the patient was registered
        List<Patient> registeredPatients = Nurse.patients;
        Assertions.assertEquals(1, registeredPatients.size());
        Assertions.assertEquals("John", registeredPatients.get(0).firstName);
        Assertions.assertEquals("Doe", registeredPatients.get(0).lastName);
        Assertions.assertEquals("1234567890", registeredPatients.get(0).phoneNumber);
        Assertions.assertEquals(30, registeredPatients.get(0).age);

        // Verify output contains success message
        String output = getOutput();
        assertTrue(output.contains("Patient registered successfully"));
    }

    // Additional tests for SecondaryRole and tertiaryDetails can be added once implemented
}