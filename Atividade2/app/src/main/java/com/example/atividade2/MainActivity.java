package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Info";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Disparou onCreate");

        final Intent intent = new Intent(this, FarenheitActivity.class);
        final EditText celsiusInput = (EditText) findViewById(R.id.editCelsiusTemperature);
        Button convertBtn = (Button) findViewById(R.id.convertBtn);
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusInputText = celsiusInput.getText().toString();
                intent.putExtra("celsiusTemperature", celsiusInputText);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Disparou onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Disparou onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Disparou onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Disparou onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Disparou onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Disparou onRestart");
    }
}