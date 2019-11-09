package com.example.lawin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class warning extends AppCompatActivity {

    ImageView profile, reports, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        profile = (ImageView) findViewById(R.id.profile);
        reports = (ImageView) findViewById(R.id.reports);
        home = (ImageView) findViewById(R.id.home);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent userprofileIntent = new Intent(warning.this, user_profile.class);
                startActivity(userprofileIntent);

            }
        });

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reportpageIntent = new Intent(warning.this, report_page.class);
                startActivity(reportpageIntent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homepageIntent = new Intent(warning.this, home_page.class);
                startActivity(homepageIntent);

            }
        });


    }
}
