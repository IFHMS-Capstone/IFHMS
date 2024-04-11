package com.Authentication;

import java.util.List;

public class RoleBasedAuthenticationStrategy implements AuthenticationStrategy{
    private List<User> users;

    public RoleBasedAuthenticationStrategy(List<User> users) {
        this.users = users;
    }

    @Override
    public User authenticate(String username, String password, String requiredRole) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getRole().equals(requiredRole)) {
                return user;
            }
        }
        return null;
    }
}
