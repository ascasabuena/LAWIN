package com.example.lawin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class urgent extends AppCompatActivity {

    ImageView profile, reports, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent);

        profile = (ImageView) findViewById(R.id.profile);
        reports = (ImageView) findViewById(R.id.reports);
        home = (ImageView) findViewById(R.id.home);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent userprofileIntent = new Intent(urgent.this, user_profile.class);
                startActivity(userprofileIntent);

            }
        });

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reportpageIntent = new Intent(urgent.this, report_page.class);
                startActivity(reportpageIntent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homepageIntent = new Intent(urgent.this, home_page.class);
                startActivity(homepageIntent);

            }
        });

    }
}
