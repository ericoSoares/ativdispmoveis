package com.unisc.pdm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Ativ4Activity extends AppCompatActivity {

    private TextView txtName, txtPhone;
    private ImageView imgView;
    private final int SELECIONAR_CONTATO = 0;
    private final int ACIONAR_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula4);

        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        imgView = findViewById(R.id.imgView);
    }

    public void contatoClick(View view) {
        startActivityForResult(
            new Intent(Intent.ACTION_PICK, Uri.parse("content://com.android.contacts/contacts")), SELECIONAR_CONTATO);
    }

    public void webClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.unisc.br")));
    }

    public void callClick(View view) {
        Uri uri = ;
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:519887712345"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        } else {
            startActivity(intent);
        }
    }

    public void maps1Click(View view) {
        startActivity(
            new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=UNISC, Santa+Cruz+do+Sul")));
    }

    public void maps2Click(View view) {
        startActivity(
            new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:-25.443195,-49.280977")));
    }

    public void maps3Click(View view) {
        String origin = "-29.6976663, -52.43867749999998";
        String destination = "-29.7176521, -52.42735859999999";
        String url = "http://maps.google.com/maps?f=d&saddr=" + origin + "&daddr=" + destination + "&hl=pt";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }


    public void cameraClick(View view) {
        startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), ACIONAR_CAMERA);
    }
}
