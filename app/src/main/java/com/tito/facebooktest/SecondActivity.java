package com.tito.facebooktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button go = findViewById(R.id.passingBtn);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    i.putExtras(bundle);
                }
                startActivity(i);

                        /* i.putExtra("Username","Meziane Dahou");
                        String text = getIntent().getStringExtra("Email");
                        i.putExtra("Etape",text);
                        startActivity(i);
                        }*/
            }
        });


    }
}