package com.example.lawin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class user_register extends AppCompatActivity {

    EditText name,age, gender, home_address, phone_number, emergency_number, username, password;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        final EditText name = (EditText) findViewById(R.id.name_register);
        final EditText age = (EditText) findViewById(R.id.age_register);
        final EditText gender = (EditText) findViewById(R.id.gender_register);
        final EditText home_address = (EditText) findViewById(R.id.home_address_register);
        final EditText phone_number = (EditText) findViewById(R.id.phone_number_register);
        final EditText emergency_number = (EditText) findViewById(R.id.emergency_contact_register);
        final EditText username = (EditText) findViewById(R.id.username_register);
        final EditText password = (EditText) findViewById(R.id.password_register);
        signup = (Button) findViewById(R.id.signup_register);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString().toUpperCase();
                String age1 = age.getText().toString().toUpperCase();
                String gender1 = gender.getText().toString().toUpperCase();
                String home_address1 = home_address.getText().toString().toUpperCase();
                String phone_number1 = phone_number.getText().toString().toUpperCase();
                String emergency_number1 = emergency_number.getText().toString().toUpperCase();
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();

                if (!name1.isEmpty()) {

                    OkHttpClient okHttpClient = new OkHttpClient();
                    String url = "https://lawin.000webhostapp.com/user_register.php?user_name=" + name1 + "&user_age=" + age1+ "&user_gender=" + gender1
                            + "&user_home_address=" + home_address1 + "&user_phone_num=" + phone_number1 + "&user_emergency_num=" + emergency_number1
                            + "&user_username=" + username1 + "&user_password=" + password1;

                    Request request = new Request.Builder().url(url).build();

                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(user_register.this, "Registration Failed", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            final String result = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(user_register.this, result, Toast.LENGTH_LONG).show();
                                    if (result.equals("success")) {

                                        Intent deviceRegisIntent = new Intent(user_register.this, device_register.class);
                                        startActivity(deviceRegisIntent);

                                        //finish();
                                        //startActivity(getIntent());
                                    }
                                    else {
                                        Toast.makeText(user_register.this, "Device name already registered.", Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                        }
                    });

                }



            }
        });

    }

}