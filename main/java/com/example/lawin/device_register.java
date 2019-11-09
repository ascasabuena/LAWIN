package com.example.lawin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class device_register extends AppCompatActivity {

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_register);

        final EditText dev_name = (EditText) findViewById(R.id.dev_name);
        final EditText dev_wear = (EditText) findViewById(R.id.dev_wear);
        final EditText dev_object = (EditText) findViewById(R.id.dev_object);
        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dev_name1 = dev_name.getText().toString().toUpperCase();
                String dev_wear1 = dev_wear.getText().toString().toUpperCase();
                String dev_object1 = dev_object.getText().toString().toUpperCase();

                if (!dev_name1.isEmpty()) {

                    OkHttpClient okHttpClient = new OkHttpClient();
                    String url = "https://lawin.000webhostapp.com/device_register.php?device_name=" + dev_name1 + "&device_id_wearable="
                            + dev_wear1 + "&device_id_object=" + dev_object1;

                    Request request = new Request.Builder().url(url).build();

                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(@NotNull Call call, @NotNull IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(device_register.this, "Registration Failed", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        @Override
                        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                            final String result = response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(device_register.this, result, Toast.LENGTH_LONG).show();
                                    if (result.equals("success")) {

                                        Intent homepageIntent = new Intent(device_register.this, home_page.class);
                                        startActivity(homepageIntent);

                                        //finish();
                                        //startActivity(getIntent());
                                    }
                                    else {
                                        Toast.makeText(device_register.this, "Device name already registered.", Toast.LENGTH_LONG).show();

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
