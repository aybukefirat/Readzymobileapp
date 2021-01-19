package com.aybukefirat.bookmyapp.model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aybukefirat.bookmyapp.MainActivity;
import com.aybukefirat.bookmyapp.R;

public class Register extends AppCompatActivity {

    EditText rUserName,rUserEmail,rUserPass,rConfPass;
    Button syncAccount;
    TextView loginAct;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Create New Readzy Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rUserName= findViewById(R.id.userName);
        rUserEmail= findViewById(R.id.userEmail);
        rUserPass= findViewById(R.id.password;
        rConfPass= findViewById(R.id.passwordConfirm);

        syncAccount= findViewById(R.id.createAccount);
        loginAct=findViewById(R.id.login);
        progressBar = findViewById(R.id.progressBar4);

        syncAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uUsername= rUserName.getText().toString();
                String uUserEmail= rUserEmail.getText().toString();
                String uUserPass= rUserPass.getText().toString();
                String uUserConfPass= rConfPass.getText().toString();

                if(uUsername.isEmpty()||uUserEmail.isEmpty()||uUserPass.isEmpty()||uUserConfPass.isEmpty()){
                    Toast.makeText(Register.this,"All Fields Are Required",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!uUserPass.equals(uUserConfPass)){
                    rConfPass.setError("Password do not match");
                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        startActivity(new Intent(this, MainActivity.class));
        finish();

        return super.onOptionsItemSelected(item);

    }
}