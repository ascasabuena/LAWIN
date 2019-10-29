package com.example.lawin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class login extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView signup;
    public static String host = "lawin.000webhostapp.com";
    public static String password1 = "bearammm";

    public static String uname, uage, ugender, uaddress, uphonenum, uemernum, uusername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = (EditText)findViewById(R.id.username_login);
        final EditText password = (EditText)findViewById(R.id.password_login);
        login = (Button) findViewById(R.id.login);
        signup = (TextView) findViewById(R.id.signup_login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(login.this, user_register.class);
                startActivity(registerIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username1 = username.getText().toString();
                String password1 = password.getText().toString();

                background bg = new background();
                String result = "";
                try {
                    result = bg.execute(username1, password1).get();
                } catch(Exception e) {
                    Log.d("Error login",  e.getMessage());
                }



                if (!result.equals("failed")){
//                    Toast.makeText(login.this, result, Toast.LENGTH_LONG).show();
                    try {
                        JSONObject jo = new JSONObject(result);

                        Toast.makeText(login.this, "Login success", Toast.LENGTH_LONG).show();

                        uname = jo.getString("user_name");
                        uage = jo.getString("user_age");
                        ugender = jo.getString("user_gender");
                        uaddress = jo.getString("user_home_address");
                        uphonenum = jo.getString("user_phone_num");
                        uemernum = jo.getString("user_emergency_num");
                        uusername = jo.getString("user_username");

                        Intent homepageIntent = new Intent(login.this, home_page.class);
                        startActivity(homepageIntent);


                    }catch (Exception e){
                        Toast.makeText(login.this, "Login Failed mama", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(login.this, "Login Failed", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
