package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    EditText weight, heightFt, heightInc;
    Button calculateBtn;
    TextView result , resultCondition;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id define with variable
        weight = findViewById(R.id.editWeight);
        heightFt = findViewById(R.id.editHeightFt);
        heightInc = findViewById(R.id.editHeightInch);
        calculateBtn = findViewById(R.id.calculateBtn);
        result = findViewById(R.id.resultText);
        imgView = findViewById(R.id.imgView);
        resultCondition = findViewById(R.id.resultCondition);


        // picasso initial image define
        Picasso.get().load("https://tinyurl.com/yw788kfe").into(imgView);


        // calculate method
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                // input number store in variable
                int wt = Integer.parseInt(weight.getText().toString());
                int feet = Integer.parseInt(heightFt.getText().toString());
                int inch = Integer.parseInt(heightInc.getText().toString());

                // total Inch
                int totalInch = (feet * 12) + inch ;

                //total cm
                double totalCm = totalInch * 2.54;

                // total meter
                double totalMeter = totalCm/100;

                //total meter
                double bmi = wt/(totalMeter*totalMeter);

                // bmi show
                result.setText("Your BMI is : " + String.format("%.2f", bmi));

                //condition wise
                if(bmi > 25){
                    Picasso.get().load("https://tinyurl.com/mrxwhn5t").into(imgView);
                    resultCondition.setText("You are Overweight");
                } else if(bmi < 18){
                    resultCondition.setText("You are Underweight");
                    Picasso.get().load("https://tinyurl.com/n7de37e2").into(imgView);
                } else {
                    resultCondition.setText("You are Normal");
                    Picasso.get().load("https://tinyurl.com/ycy55b65").into(imgView);
                }
            }
        });
    }
}