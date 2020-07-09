package com.example.callapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CallReceivedActivity extends AppCompatActivity {

    String phoneNo = "", firstName="", lastName="";

    TextView textViewName;
    TextView textViewPhno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_received);

        Intent intent = getIntent();
        if(intent!=null){
            phoneNo = intent.getStringExtra("phoneNo");
            firstName = intent.getStringExtra("firstName");
            lastName = intent.getStringExtra("lastName");
        }


        textViewName = findViewById(R.id.name);
        textViewPhno = findViewById(R.id.phoneNumber);

        String s1 = "";
        if(firstName!=null){
            s1 = firstName+" "+lastName;
        }
        textViewName.setText(s1);
        textViewPhno.setText(phoneNo);

    }
}
