package com.tito.facebooktest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView displayed = findViewById(R.id.textView);
        Bundle b = getIntent().getExtras();
        String data = b.getString("DATA");
        displayed.setText(data);


        TextView displayed2 = findViewById(R.id.textView2);
        Bundle c = getIntent().getExtras();
        String data1 = c.getString("Email");
        displayed2.setText(data1);

        Button logout = findViewById(R.id.button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ThirdActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

    }

}
