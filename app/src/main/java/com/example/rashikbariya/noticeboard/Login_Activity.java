package com.example.rashikbariya.noticeboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login_Activity extends AppCompatActivity {

    EditText name, password;
    Button login, signup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        name = findViewById(R.id.etname);
        password = findViewById(R.id.etpassword);
        login = findViewById(R.id.btnLogin);
        signup = findViewById(R.id.btnSignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login_Activity.this, Signup_Activity.class);
                startActivity(i);

            }
        });
    }


}
