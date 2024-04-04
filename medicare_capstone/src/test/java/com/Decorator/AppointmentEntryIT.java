package com.Decorator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppointmentEntryIT {
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
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void testBasicAppointmentBooking() {
        provideInput("1\n");
        AppointmentEntry appointmentEntry = new AppointmentEntry();

        appointmentEntry.displayAppointment();

        String output = getOutput();
        assertTrue(output.contains("You have booked a General appointment at Ugx.10000"));
    }

    @Test
    public void testSpecialistAppointmentBooking() {
        provideInput("2\n");
        AppointmentEntry appointmentEntry = new AppointmentEntry();

        appointmentEntry.displayAppointment();

        String output = getOutput();
        assertTrue(output.contains("You have booked a Specialist appointment at Ugx.:"));
    }
}