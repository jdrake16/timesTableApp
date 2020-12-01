package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    public void generateTimesTable(int timesTable) {

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++ ) {
            timesTableContent.add(Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        myListView.setAdapter(arrayAdapter);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar mySeekBar = findViewById(R.id.timesTableSeekBar);
        myListView = findViewById(R.id.timesTableListView);

        mySeekBar.setMax(20);
        mySeekBar.setProgress(10);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //to set minimum position on the seekbar
                int min = 1;
                int timesTable;

                if (progress < min) {
                    timesTable = min;
                    mySeekBar.setProgress(min);
                } else {
                    timesTable = progress;
                }
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        generateTimesTable(10);

    }


}