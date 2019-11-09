package com.example.lawin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home_page extends AppCompatActivity {

    ImageView send, profile, reports, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        send = (ImageView) findViewById(R.id.send_report);
        profile = (ImageView) findViewById(R.id.profile);
        reports = (ImageView) findViewById(R.id.reports);
        home = (ImageView) findViewById(R.id.home);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent casegeneratedIntent = new Intent(home_page.this, case_generated.class);
                startActivity(casegeneratedIntent);

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent userprofileIntent = new Intent(home_page.this, user_profile.class);
                startActivity(userprofileIntent);

            }
        });

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reportpageIntent = new Intent(home_page.this, report_page.class);
                startActivity(reportpageIntent);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homepageIntent = new Intent(home_page.this, home_page.class);
                startActivity(homepageIntent);

            }
        });




    }
}
