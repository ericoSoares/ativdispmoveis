package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FarenheitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farenheit);

        Intent intent = getIntent();
        String valor = intent.getStringExtra("celsiusTemperature");
        double fahrenheit = Double.parseDouble(valor) * 1.8 + 32;
        TextView fTextView = (TextView) findViewById(R.id.farenheitText);
        fTextView.setText(fahrenheit + "");
    }
}