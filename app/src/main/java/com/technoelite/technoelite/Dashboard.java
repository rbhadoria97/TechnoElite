package com.technoelite.technoelite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class
Dashboard extends AppCompatActivity {

    private ImageView AboutUs;
    private ImageView Teams;
    private ImageView Events;
    private ImageView Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       AboutUs = (ImageView)findViewById(R.id.ivAboutUs);
       Teams =(ImageView)findViewById(R.id.ivTeam);
       Events = (ImageView)findViewById(R.id.ivEvent);
       Home = (ImageView)findViewById(R.id.ivhome);
        AboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, aboutus.class));
            }
        });

        Teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Teaminfo.class));
            }
        });

        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Events.class));
            }
        });

       Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, TechnoFront.class));
            }
        });


    }
}
