package com.aybukefirat.readzy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button callSignUp;
    TextView logoText,sloganText;
    TextInputLayout username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        callSignUp= findViewById(R.id.signup_screen);
        logoText= findViewById(R.id.logo_name);
        sloganText=findViewById(R.id.slogan_name);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        login_btn= findViewById(R.id.Login.btn);

                callSignUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Login.this,SignUp.class);

                        Pair[] pairs=  new Pair[6];
                        pairs [0]= new Pair< View,String>(logoText,"logo_text");
                        pairs [1]= new Pair< View,String>(sloganText,"logo_desc");
                        pairs [2]= new Pair< View,String>(username,"username_tran");
                        pairs [3]= new Pair< View,String>(password,"password_tran");
                        pairs [4]= new Pair< View,String>(login_btn,"button_tran");
                        pairs [5]= new Pair< View,String>(callSignUp,"login_signup_tran");

                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                        startActivity(intent,options.toBundle());
                    }


                });

    }
}