package com.example.lawin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class user_profile extends AppCompatActivity {

    ImageView reports, home;
    TextView username_profile, name, age,gender, home_address, phone_num, emergency_num, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_layout);

        reports = (ImageView) findViewById(R.id.reports);
        home = (ImageView) findViewById(R.id.home);
        username_profile = (TextView) findViewById(R.id.username_profile);
        name = (TextView) findViewById(R.id.name_profile);
        age = (TextView) findViewById(R.id.age_profile);
        gender = (TextView) findViewById(R.id.gender_profile);
        home_address = (TextView) findViewById(R.id.home_address_profile);
        phone_num = (TextView) findViewById(R.id.phone_number_profile);
        emergency_num = (TextView) findViewById(R.id.emergency_contact_profile);
        username_profile = (TextView) findViewById(R.id.username_profile);

        username_profile.setText(login.uusername);
        name.setText(login.uname);
        age.setText(login.uage);
        gender.setText(login.ugender);
        home_address.setText(login.uaddress);
        phone_num.setText(login.uphonenum);
        emergency_num.setText(login.uemernum);

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reportpageIntent = new Intent(user_profile.this, report_page.class);
                startActivity(reportpageIntent);

                username_profile = findViewById(R.id.username_profile);
                username_profile.setText(login.uname);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homepageIntent = new Intent(user_profile.this, home_page.class);
                startActivity(homepageIntent);

            }
        });

        userprofile();

    }

    protected void userprofile(){

        OkHttpClient client = new OkHttpClient();
        String url ="https://lawin.000webhostapp.com/user_profile.php";
        Request request = new Request.Builder().url(url).build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(user_profile.this, "Failed to load Database!",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String result = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
//                            Toast.makeText(user_profile.this, "Rsult: " + result, Toast.LENGTH_LONG).show();
//                            JSONArray ja = new JSONArray(result);
//                            devices_name = new String[ja.length()];
//                            status = new String[ja.length()];
//                            loc = new String[ja.length()];
//
//                            for (int n = 0; n < ja.length(); n++) {
//
//                                JSONObject jo = ja.getJSONObject(n);
//                                String device = jo.getString("device_name");
//                                String stat = jo.getString("device_status");
//                                String loc1 = jo.getString("device_location");
//
//
//                                devices_name[n] = device;
//                                status[n] = stat;
//                                loc[n] = loc1;
//
//                            }
//
//                            DeviceAdapter da = new DeviceAdapter(MainActivity.this,devices_name,status, loc);
//                            devicesListView.setAdapter(da);

                        } catch (Exception e) {
                            Toast.makeText(user_profile.this, result, Toast.LENGTH_LONG).show();

                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
