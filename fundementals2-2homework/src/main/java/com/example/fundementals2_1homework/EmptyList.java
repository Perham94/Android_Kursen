package com.example.fundementals2_1homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmptyList extends AppCompatActivity {

    public View getview;
    public static final int TEXT_REQUEST = 1;
    private LinearLayout list;
    public int index;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_list);




    }

    public void addItem(View view) {

        Intent intent = new Intent(this, ShoppingList.class);
        getview = view;
        startActivityForResult(intent, TEXT_REQUEST);


    }


    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {



        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(ShoppingList.EXTRA_REPLY);


                 list = findViewById(R.id.itemList);

                 text =   list.findViewById(list.getChildAt(index).getId());


                if (text.getText().toString().isEmpty()) {

                    text.setText(reply);

                }

                ++index;


            }
        }

    }




}
