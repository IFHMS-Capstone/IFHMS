package com;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.Authentication.*;

import com.chainofResponsibility.*;

public class App {
    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args) throws Exception {

        // Create roles
        Role patientRole = new Role("patient");
        Role healthWorkerRole = new Role("health worker");

        // Create users with roles
        User patientUser = new User("patient1", "pass22#", Arrays.asList(patientRole));
        User doctorUser = new User("doctor44", "iamdoc99", Arrays.asList(healthWorkerRole, patientRole));

        List<User> users = Arrays.asList(patientUser, doctorUser);

        Scanner scanner = new Scanner(System.in);
        System.out.println(".........WELCOME TO IHFMS........... ");

        // Prompt for user login
        System.out.println("Please log in to continue:");

        // Prompt for username
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        // Prompt for password
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // Prompt for role
        System.out.println("Enter role(patient/health worker): ");
        String role = scanner.nextLine();

        // Authenticate user
        AuthenticationStrategy authStrategy = new RoleBasedAuthenticationStrategy(users);
        boolean isAuthenticated = authStrategy.authenticate(username, password, role);

        if (isAuthenticated) {
            System.out.println("Authentication successful!! Welcome " + username);
            
            IRole rolechain1 = new PatientRole();
            IRole rolechain2 = new HealthworkerRole();

            rolechain1.setnextRole(rolechain2);
            rolechain1.execute(role);
           

            // new MessagingMain();
            scanner.close();

        } else {
            System.out.println("Authentication failed. Invalid credentials or role.");
        }
        scanner.close();
    }
}