package com.aybukefirat.bookmyapp.model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.aybukefirat.bookmyapp.R;

public class Login extends AppCompatActivity {

    EditText lEmail,lPassword;
    Button loginNow;
    TextView forgetPass,createAcc;
    ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login to Readzy");

        lEmail= findViewById(R.id.email);
        lPassword=findViewById(R.id.lPassword);
        loginNow=findViewById(R.id.loginBtn);
        spinner=findViewById(R.id.progressBar3);
        forgetPass=findViewById(R.id.forgotPasword);
        createAcc=findViewById(R.id.createAccount);

        loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail=lEmail.getText().toString();
                String mPassword=lPassword.getText().toString();

                if(mEmail.isEmpty()||mPassword.isEmpty()){
                    Toast.makeText(Login.this,"Fields Are Required",Toast.LENGTH_SHORT).show();
                    return;
                }
                spinner.setVisibility(View.VISIBLE);
            }
        });
    }

}