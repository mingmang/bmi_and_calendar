package com.example.bmi_and_calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button Btn_map,Btn_cal,Btn_bmi;
    public TextView Title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Btn_map=findViewById(R.id.button_gps);
        Btn_cal=findViewById(R.id.button_calendar);
        Btn_bmi=findViewById(R.id.button_bmi);
        Title=findViewById(R.id.tv_title);



        Btn_cal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Calendar.class);
                startActivity(intent);
            }

        });

        Btn_bmi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),BMI.class);
                startActivity(intent);
            }
        });
    }

}