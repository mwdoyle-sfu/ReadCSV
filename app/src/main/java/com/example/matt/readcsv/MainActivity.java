package com.example.matt.readcsv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readWeatherData();
    }

    private List<WeatherSample> weatherSamples = new ArrayList<>();

    // Based on info from: http:// stackoverflow.com/a/19976110
    private void readWeatherData() {
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";

        try {
            // Step over headers
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                Log.d("MyActivity", "Line: " + line);

                // Split by ','
                String[] tokens = line.split(",");

                // Read the data
                WeatherSample sample = new WeatherSample();

                sample.setMonth(tokens[0]);

                if(tokens[1].length() > 0){
                    sample.setRainfall(Double.parseDouble(tokens[1]));
                } else{
                    sample.setRainfall(0);
                }
                if(tokens.length >= 3 && tokens[2].length() > 0) {
                    sample.setSunhours(Integer.parseInt(tokens[2]));
                } else{
                    sample.setSunhours(0);
                }

                weatherSamples.add(sample);

                Log.d("MyActivity", "Just created " + sample);

            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line " + line, e);
        }
    }
}
