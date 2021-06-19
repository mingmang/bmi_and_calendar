package com.example.bmi_and_calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BMI extends AppCompatActivity {

    public TextView height, weight, BMI, ResultIs, numBMI, korResult;
    public EditText EditHeight, EditWeight;
    public Button btn_result;
    public String num, kor;
    public double h, w, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        height = findViewById(R.id.tv_height);
        weight = findViewById(R.id.tv_weight);
        BMI = findViewById(R.id.tv_BMI);
        ResultIs = findViewById(R.id.tv_result_is);
        numBMI = findViewById(R.id.tv_BMI_num);
        korResult = findViewById(R.id.tv_result_kor);
        EditHeight = findViewById(R.id.et_height);
        EditWeight = findViewById(R.id.et_weight);
        btn_result = findViewById(R.id.btn_gotoresult);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = EditHeight.getText().toString();
                h = Integer.parseInt(num);
                num = EditWeight.getText().toString();
                w = Integer.parseInt(num);
                res = w / h / h * 10000;
                num = String.format("%.2f", res);

                if (res >= 40)
                    kor = "고도비만 입니다.";
                else if (res >= 30)
                    kor = "비만 입니다.";
                else if (res >= 25)
                    kor = "과체중 입니다.";
                else if (res >= 20)
                    kor = "정상 입니다.";
                else
                    kor = "저체중 입니다.";

                numBMI.setText(num);
                korResult.setText(kor);
                BMI.setVisibility(View.VISIBLE);
                ResultIs.setVisibility(View.VISIBLE);
                numBMI.setVisibility(View.VISIBLE);
                korResult.setVisibility(View.VISIBLE);
            }
        });
    }
}