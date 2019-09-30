package com.example.fundementals2_1homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingList extends AppCompatActivity {
    View setfield ;

    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    private  String  message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
    }

    public void setItem(View view) {

        Intent reply= new Intent();
        TextView text = findViewById(view.getId());

        message  =   text.getText().toString();



       reply.putExtra(EXTRA_REPLY, message);
        setResult(RESULT_OK,reply);
        finish();

    }
}
