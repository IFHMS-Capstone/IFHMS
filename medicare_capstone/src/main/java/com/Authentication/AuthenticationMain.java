package com.Authentication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AuthenticationMain {
    public static void main(String[] args) {
        // Create roles
        Role patientRole = new Role("patient");
        Role healthWorkerRole = new Role("health worker");

        // Create users with roles
        User patientUser = new User("patient1", "pass22#", Arrays.asList(patientRole));
        User doctorUser = new User("doctor44", "iamdoc99", Arrays.asList(healthWorkerRole));

        List<User> users = Arrays.asList(patientUser, doctorUser);

        // Initialize the authentication strategy
        AuthenticationStrategy authStrategy = new RoleBasedAuthenticationStrategy(users);

        // Create scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println(".........WELCOME TO IHFMS........... ");

        // Prompt for username
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        // Prompt for password
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        //Prompt for role
        System.out.println("Enter role: ");
        String role = scanner.nextLine();

        // Call the authentication method
        boolean isAuthenticated = authStrategy.authenticate(username, password, role);

        if (isAuthenticated) {
            System.out.println("Authentication successful!! Welcome " + username);
        } else {
            System.out.println("Authentication failed. Invalid credentials or role.");
        }

        scanner.close();
    }

}