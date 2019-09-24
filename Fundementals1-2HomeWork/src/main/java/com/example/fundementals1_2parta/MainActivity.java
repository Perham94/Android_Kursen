package com.example.fundementals1_2parta;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;
    private  Button  mButtonZero;
    private  View countColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        mButtonZero = findViewById(R.id.button_zero);


    }

    public void showToast(View view) {

        Toast toast = Toast.makeText(this,R.string.toast_message,Toast.LENGTH_LONG);

        toast.show();
    }

    public void countUp(View view) {
        countColor = view;
        ++mCount;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));

            view.setBackgroundColor(Color.parseColor("#50EA21"));
            mButtonZero.setBackgroundColor(Color.parseColor("#FA0EE0"));

        }


    }


    public void resets(View view) {

        if (mShowCount != null) {
            mCount = 0;
            mShowCount.setText(Integer.toString(mCount));

            view.setBackgroundColor(Color.parseColor("#948F8F"));
            countColor.setBackgroundColor(Color.parseColor("#1D588F"));

        }

    }
}
