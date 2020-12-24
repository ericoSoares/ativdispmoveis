package com.example.trab1;

import android.content.Intent;
import android.os.Bundle;

import com.example.trab1.data.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final TextView registerButton = findViewById(R.id.linkRegister);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                login(username, password);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(String email, String password) {
        final String userEnteredEmail = email;
        final String userEnteredPwd = password;

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = ref.orderByChild("email").equalTo(userEnteredEmail);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {

                    User user = new User();
                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        user = childSnapshot.getValue(User.class);
                    }

                    String passwordFromDB = user.password;

                    if (passwordFromDB.equals(userEnteredPwd)) {
                        String usernameFromDB = user.username;
                        Intent intent = new Intent(getApplicationContext(), NewRegisterActivity.class);
                        intent.putExtra("username", usernameFromDB);

                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Senha inválida", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Email não encontrado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}