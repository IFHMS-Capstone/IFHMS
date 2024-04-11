package com.Authentication;

public interface AuthenticationStrategy {
    User authenticate(String username, String password, String requiredRole);
}
