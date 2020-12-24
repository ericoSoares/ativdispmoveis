package com.example.trab1.data.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    public String id;
    public String username;
    public String email;
    public String password;
    public ArrayList<Register> registers;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.registers = new ArrayList<Register>();
    }

}