package com.example.fundementals2_1homework;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Homework extends AppCompatActivity {

    private int counter;
    private    TextView showcouter;
    private static final String savedCount = "textKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);
        showcouter= (TextView) findViewById(R.id.text_Counter);



    if(savedInstanceState!= null) {


             showcouter.setText(String.valueOf(savedInstanceState.getInt("textKey")));

            }



    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (showcouter !=  null) {

            outState.putInt("textKey",counter);
        }
    }


    public void countUp(View view) {

        ++counter;

        if(showcouter.getText() != null)  {

            showcouter.setText(String.format(Integer.toString(counter)));


             Integer.toString(counter);
        }


    }
}
