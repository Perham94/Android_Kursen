package com.example.fundementals2_1homework;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EmptyList extends AppCompatActivity {

    private static final String contexts ="context_text";
    public View getview;
    public static final int TEXT_REQUEST = 1;
    private LinearLayout list;

    private TextView text;
    private  TextView amount;
    private  TextView restore;
    private EditText mLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_list);

        list = findViewById(R.id.itemList);

        mLocationEditText = findViewById(R.id.shop_location_text);
        if (savedInstanceState != null) {

            for(int l = 0 ; l < list.getChildCount(); l++) {



                restore = findViewById(list.getChildAt(l).getId());




                    restore.setText(savedInstanceState.getStringArrayList("context_text").get(l));



            }

        }

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

                for (int index =0 ; index <list.getChildCount(); index++) {


                    text = list.findViewById(list.getChildAt(index).getId());


                    if (text.getText().toString().isEmpty()) {

                        text.setText(reply);
                        break;

                    }

                }




            }
        }

    }


    public void pickShop(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        ArrayList<String> savedList = new ArrayList<String>();

        for(int i = 0 ; i < list.getChildCount(); i++) {
            amount = list.findViewById(list.getChildAt(i).getId());

                savedList.add(i, amount.getText().toString());
                if (amount.getText() != null) {

                    outState.putStringArrayList("context_text", savedList);
                }


        }
    }





}
