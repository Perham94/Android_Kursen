package com.example.picker_for_time;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTime(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void processTimePickerResult(int hour, int min) {

        String hour_string = Integer.toString(hour);
        String min_string = Integer.toString(min);
        String message = "Hours : " + hour_string + "\t" + "min :" + min_string;


        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show();


    }
}
