package com.example.trab1.data;

import androidx.annotation.NonNull;

import com.example.trab1.data.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class Repository {

    DatabaseReference rootNode;

    public Repository() {
        rootNode = FirebaseDatabase.getInstance().getReference();
    }

    public void login(String email, String password) {

    }

    public void register(User user) {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        user.id = uuid;
        rootNode.child("users").child(uuid).setValue(user);
    }
}
