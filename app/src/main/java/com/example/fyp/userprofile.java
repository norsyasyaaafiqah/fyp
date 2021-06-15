package com.example.fyp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class userprofile extends AppCompatActivity {

    private TextView textViewUsername, textViewUserEmail, textViewPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        textViewUsername = (TextView)findViewById(R.id.editTextUserName);
        textViewUserEmail=(TextView)findViewById(R.id.editTextEmail);
        textViewPhoneNumber=(TextView)findViewById(R.id.editTextPhoneNumber);


    }
}