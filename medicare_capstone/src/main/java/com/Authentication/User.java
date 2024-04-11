package com.Authentication;

import java.util.List;
import java.util.Iterator;

public class User {
    private String username;
    private String password;
    private List<Role> roles;

    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Iterator<Role> getRolesIterator() {
        return roles.iterator();
    }
}