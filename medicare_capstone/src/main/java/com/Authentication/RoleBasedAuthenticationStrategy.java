package com.Authentication;

import java.util.List;
import java.util.Iterator;

public class RoleBasedAuthenticationStrategy implements AuthenticationStrategy{
    private List<User> users;

    public RoleBasedAuthenticationStrategy(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean authenticate(String username, String password, String requiredRole) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                Iterator<Role> roles = user.getRolesIterator();
                while (roles.hasNext()) {
                    Role role = roles.next();
                    if (role.getName().equals(requiredRole)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}