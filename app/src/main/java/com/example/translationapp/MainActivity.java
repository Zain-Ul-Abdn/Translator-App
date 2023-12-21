package com.example.translationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView viewPolicyPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Removing default top header of application
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //This line hide default header


        setContentView(R.layout.activity_main);

        //Get policyPage navigation link
        viewPolicyPage = findViewById(R.id.readPolicyLink);

        viewPolicyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //These piece of code for navigate to Policy Page
                    Intent intent = new Intent(MainActivity.this, PolicyPage.class);
                    startActivity(intent);

                }catch (Exception e){

                    //Handle Error
                    Toast.makeText(MainActivity.this, "Unable to redirect Policy Page", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}