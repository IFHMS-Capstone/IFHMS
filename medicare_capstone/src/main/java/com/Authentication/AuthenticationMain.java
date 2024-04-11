package com.Authentication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AuthenticationMain {
    public static void main(String[] args) {

        // Create scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        System.out.println(".........WELCOME TO IHFMS........... ");

        List<User> users = Arrays.asList(
                new User("doctor44", "iamdoc99@", "healthworker"),
                new User("patient", "pass33$", "patient"));

        // Prompt for username
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        // Prompt for password
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        // Prompt for role
        System.out.println("Enter role: ");
        String role = scanner.nextLine();

        // Authenticate User
        // Initialize the authentication strategy
        AuthenticationStrategy authStrategy = new RoleBasedAuthenticationStrategy(users);
        User authenticatedUser = authStrategy.authenticate(username, password, role);

        if (authenticatedUser != null) {
            System.out.println("Authentication successful!! Welcome " + username);
        } else {
            System.out.println("Authentication failed. Invalid credentials or role.");
        }

        scanner.close();
    }

}