package com.tito.facebooktest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.SharedPreferences;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    private final String KEY = "edittextValue";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText username = findViewById(R.id.editText1);
        // String texttopass = username.getText().toString();
        EditText password = findViewById(R.id.editText2);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Email)) {
            username.setText(sharedpreferences.getString(Email, ""));

        }
        Button login = findViewById(R.id.loginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("test@gmail.com") && password.getText().toString().equals("123456")) {
                saveFromEditText(username.getText().toString());
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("Email","test@gmail.com");
                i.putExtra("DATA","Meziane Dahou");
                startActivity(i);
                } else 
                    {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                MainActivity.this);
                        // set title
                        alertDialogBuilder.setTitle("Login Error");
                        alertDialogBuilder.setCancelable(true);
                        // set dialog message
                        alertDialogBuilder
                                .setMessage("Wrong E-mail or Password")
                                .setCancelable(true)
                                .setPositiveButton( "TRY AGAIN",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int i) {
                                        dialog.cancel();
                                    }
                                })
                                .setNegativeButton("CANCEL",new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int i) {
                                        MainActivity.super.onBackPressed();
                                    }
                                });

                        // create alert dialog
                        AlertDialog alertDialog = alertDialogBuilder.create();

                        // show it
                        alertDialog.show();

                    };
            }

        });

    }
    private String getValue() {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String savedValue = sharedPref.getString(KEY, "username");
        return savedValue;
    }

    private void saveFromEditText(String text) {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY, text);
        editor.apply();
    }
}