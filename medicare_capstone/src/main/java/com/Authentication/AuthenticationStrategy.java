package com.Authentication;

public interface AuthenticationStrategy {
    boolean authenticate(String username, String password, String requiredRole);
}