package com.technoelite.technoelite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TechnoFront extends AppCompatActivity {
    private ImageView ListButton;
    private ImageView LoginImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techno_front);

        ListButton = (ImageView)findViewById(R.id.ivlistbutton);
        LoginImage = (ImageView)findViewById(R.id.ivlock);

       ListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TechnoFront.this, Dashboard.class));
            }
        });

        LoginImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TechnoFront.this, MainActivity.class));
            }
        });
    }
}
