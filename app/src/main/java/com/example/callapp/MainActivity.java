package com.example.callapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{

    private static final int MY_PERMISSIONS_READ_CALL_LOG = 1;
    private static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 2;
    private static final int MY_PERMISSIONS_REQUEST_PROCESS_OUTGOING_CALLS = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(getApplicationContext().checkSelfPermission(Manifest.permission.READ_CALL_LOG)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CALL_LOG},
                    MY_PERMISSIONS_READ_CALL_LOG);
        }

        if (getApplicationContext().checkSelfPermission(Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission has not been granted, therefore prompt the user to grant permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }

        if (getApplicationContext().checkSelfPermission(Manifest.permission.PROCESS_OUTGOING_CALLS)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission has not been granted, therefore prompt the user to grant permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},
                    MY_PERMISSIONS_REQUEST_PROCESS_OUTGOING_CALLS);
        }
    }
}
