package com.example.rashikbariya.noticeboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Signup_Activity extends AppCompatActivity {
    EditText name, email, phone, batch, password;
    Button signup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siginup);

        name = findViewById(R.id.etname);
        email = findViewById(R.id.etemail);
        phone = findViewById(R.id.etphone);
        batch = findViewById(R.id.etbatch);
        password = findViewById(R.id.etbatch);
        signup = findViewById(R.id.btnsignup);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //error solve this shit

                try {
                    URL url = new URL ( "https://b-rashik.000webhostapp.com/register.php?name="+name+"&password="+password+"&email="+email+"&phone="+phone+"&batch"+batch);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    try {
                        BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader(urlConnection.getInputStream()));
         StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine())!= null)
            {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
//            return stringBuilder.toString();
                    } finally {
                        urlConnection.disconnect();
                    }

                    Toast.makeText(Signup_Activity.this, "data added", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Signup_Activity.this, "error", Toast.LENGTH_SHORT).show();

                }


            }
        });




    }

//    public void registerUser(View view) {
//        String sname, semail, sphone, sbatch, spassword;
//        sname = name.getText().toString();
//        semail = email.getText().toString();
//        sphone = phone.getText().toString();
//        sbatch = batch.getText().toString();
//        spassword= password.getText().toString();
//
//
//
//    }
//protected String doInBackground() //what to do when data has arrived
//{
//
//    try
//    {
//
//        URL url = new URL ( "https://b-rashik.000webhostapp.com/register.php?name="+name+"&password="+password+"&email="+email+"&phone="+phone+"&batch"+batch);
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        try
//        {
//            BufferedReader bufferedReader = new BufferedReader ( new InputStreamReader(urlConnection.getInputStream()));
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine())!= null)
//            {
//                stringBuilder.append(line).append("\n");
//            }
//            bufferedReader.close();
//            return stringBuilder.toString();
//        }
//        finally
//        {
//            urlConnection.disconnect();
//        }
//    }
//    catch (Exception e)
//    {
//        return null;
//    }
//
//    // spinner.setVisibility(View.GONE);
//}


}
