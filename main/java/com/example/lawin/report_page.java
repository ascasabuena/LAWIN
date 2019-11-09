package com.example.lawin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class report_page extends AppCompatActivity {

    ImageView profile, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);

        profile = (ImageView) findViewById(R.id.profile);
        home = (ImageView) findViewById(R.id.home);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent userprofileIntent = new Intent(report_page.this, user_profile.class);
                startActivity(userprofileIntent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homepageIntent = new Intent(report_page.this, home_page.class);
                startActivity(homepageIntent);

            }
        });
    }
}
