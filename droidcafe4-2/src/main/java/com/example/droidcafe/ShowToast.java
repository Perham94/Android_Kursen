package com.example.droidcafe;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowToast extends AppCompatActivity {

    private ArrayList<String> message;
    private CheckBox box;

    private String test = "";
    private LinearLayout itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_toast);


        itemList = findViewById(R.id.itemLists);


    }


    public ArrayList<String> Msg() {

        message = new ArrayList<String>();

        message.clear();
        test = "";

        for (int l = 0; l < itemList.getChildCount(); l++) {

            box = findViewById(itemList.getChildAt(l).getId());


            if (box.isChecked()) {
                message.add(box.getText().toString());
            }


        }


        return message;


    }


    public void ButtonChecked(View view) {


        Msg();


        test += "The item includes: ";
        for (int i = 0; i < message.size(); i++) {


            test += "\t" + message.get(i);

        }

        Toast toast = Toast.makeText(getApplicationContext(), test, Toast.LENGTH_LONG);
        toast.show();

    }
}
