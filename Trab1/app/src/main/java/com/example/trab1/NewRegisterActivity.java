package com.example.trab1;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class NewRegisterActivity extends AppCompatActivity {

    public boolean isTracking = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_register);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button toggleTrackBtn = findViewById(R.id.toggleTracking);
        toggleTrackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTracking) {
                    startTracking(toggleTrackBtn);
                } else {
                    stopTracking(toggleTrackBtn);
                }
            }
        });
    }

    private void startTracking(Button toggleBtn) {
        isTracking = true;
        toggleBtn.setText("Parar rastreamento");
        toggleBtn.setBackgroundColor(Color.RED);
    }

    private void stopTracking(Button toggleBtn) {
        isTracking = false;
        toggleBtn.setText("Iniciar rastreamento");
        Button defBtn = new Button(this);
        toggleBtn.setBackground(defBtn.getBackground());
    }
}