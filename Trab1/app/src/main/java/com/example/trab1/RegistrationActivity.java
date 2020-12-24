package com.example.trab1;

import android.content.Intent;
import android.os.Bundle;

import com.example.trab1.data.Repository;
import com.example.trab1.data.model.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Repository repo = new Repository();

        final TextView linkLogin = findViewById(R.id.linkLogin);
        final Button registerButton = findViewById(R.id.btnRegister);
        final EditText txtUsername = findViewById(R.id.txtUsername);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        final EditText txtPassword = findViewById(R.id.txtPwd);

        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnRegister(
                    txtEmail.getText().toString().trim(),
                    txtUsername.getText().toString().trim(),
                    txtPassword.getText().toString().trim(),
                    repo
                );
            }
        });
    }

    private void handleOnRegister(String email, String username, String password, Repository repo) {
        User user = new User(username, email, password);
        repo.register(user);
    }

    private void goToLogin() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}
