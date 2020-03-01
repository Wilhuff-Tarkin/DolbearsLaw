package com.example.dolbearscalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/*
    Back in 1897, a scientist named Amos Dolbear published an article “The Cricket as a Thermometer”
    that noted the correlation between the ambient temperature and the rate at which crickets chirp.
    The formula expressed in that article became known as Dolbear’s Law.
*/

public class MainActivity extends AppCompatActivity {

    EditText etChirps;
    Button btnSubmit;
    TextView tvInstructions;
    TextView tvResultTemp;

//    TODO
//    witty temperature comments
//    formatting
//    result in bigger font
//    sound on click?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvInstructions = findViewById(R.id.tvInstrucions);
        tvResultTemp = findViewById(R.id.tvResultTemp);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String chirps = etChirps.getText().toString();
                calculateTemperature(Integer.valueOf(chirps));
            }
        });

        tvInstructions.setText("Insert a number of chirps per minute to get current temperature.");

    }


    public void calculateTemperature (int chirpsCount){

        if (chirpsCount <=0){
            tvResultTemp.setText("No chrips, no results.");
        } else
        {

            int degreeCelsius;
            degreeCelsius = 10 + (chirpsCount - 40)/7;

            tvResultTemp.setText("Approximate temperature equals " + degreeCelsius + " degrees Celsius.");



        }


    }




}
