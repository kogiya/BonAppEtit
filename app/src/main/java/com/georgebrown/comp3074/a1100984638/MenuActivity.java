package com.georgebrown.comp3074.a1100984638;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    SparseBooleanArray sparseBooleanArray;
    ListView listView;
    ArrayList<String> orderArray = new ArrayList<String>();//to store ordered menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Get restaurant name and menu array from the intent
        Intent intent = getIntent();
        String restaurantName = intent.getStringExtra("restaurant");//restaurant name
        final String[] menu = intent.getStringArrayExtra("menu");//menu array

        //Display the restaurant name
        TextView restaurant = (TextView)findViewById(R.id.txtRestaurantName);
        restaurant.setText(restaurantName);

        //generate menu with check box
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, menu);
        listView = (ListView) findViewById(R.id.chkMenu);
        listView.setAdapter(adapter);

        //get value from check box
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sparseBooleanArray = listView.getCheckedItemPositions();
                String valueHolder ="";//to pass selected menu to toast
                int i = 0;
                while( i < sparseBooleanArray.size()){
                    if(sparseBooleanArray.valueAt(i)) {
                        valueHolder += menu[sparseBooleanArray.keyAt(i)] + "\n";
                        orderArray.add(menu[sparseBooleanArray.keyAt(i)]);//array to store ordered items
                    }
                    i++;
                }
            }
        });
    }//end of onCreate()

    //when click next button, the page change to Customer Information
    public void onClickNext(View v) {
        if (orderArray.size() == 0) {
            Toast.makeText(MenuActivity.this, "You don't order anything.\n Please select your order.", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(MenuActivity.this, CustomerActivity.class);
        intent.putExtra("order", orderArray);
        startActivity(intent);
        }
    }
}
