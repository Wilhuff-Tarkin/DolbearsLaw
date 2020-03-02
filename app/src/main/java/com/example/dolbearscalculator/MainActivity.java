package com.example.dolbearscalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

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

        tvResultTemp.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String chirps = etChirps.getText().toString();
                calculateTemperature(Integer.valueOf(chirps));
            }
        });

        tvInstructions.setText("Did you know that you can tell the temperature by counting the chirps of a cricket? Just count the number of chrips one makes in 60 seconds and place the number in the box below:");

    }


    public void calculateTemperature (int chirpsCount){

        String additionalComment = "";

        if (chirpsCount <=0){
            tvResultTemp.setText("No chrips, no results.");
        } else
        {

            int degreeCelsius;
            degreeCelsius = 10 + (chirpsCount - 40)/7;

            if (degreeCelsius < 5)
            {
                additionalComment = "A little chilly. Better take a hat.";
            } else if (degreeCelsius < 10){
                additionalComment = "Maybe go for a walk?";
            } else if (degreeCelsius < 20) {
                additionalComment = "Look for sunglasses and go for a hike.";
            } else if (degreeCelsius < 30) {
                additionalComment = "Sunscreen might be needed.";
            } else if (degreeCelsius > 30) {
                additionalComment = "Pheew, thats hot. Drink a lot of water.";
            } else if (degreeCelsius > 40) {
                additionalComment = "It's too hot. Seek shelter.";
            }

            tvResultTemp.setText("Approximate temperature equals " + degreeCelsius + " degrees Celsius. " + additionalComment);
            tvResultTemp.setVisibility(View.VISIBLE);



        }


    }




}
