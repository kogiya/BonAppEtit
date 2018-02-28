package com.georgebrown.comp3074.a1100984638;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class RestaurantActivity extends AppCompatActivity {
    Restaurant[] categoryArray;
    String[] menu;
    String restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        //Get category name from the intent
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("category");

        //Display the cuisine category
        TextView category = (TextView)findViewById(R.id.txtCategory);
        category.setText(categoryName);


        if(categoryName.equals(Restaurant.Mexican[0].getCategory()) ){
            categoryArray = Restaurant.Mexican;
        }
        else if(categoryName.equals(Restaurant.Caribbean[0].getCategory())){
            categoryArray = Restaurant.Caribbean;
        }
        else if(categoryName.equals(Restaurant.Greek[0].getCategory())){
            categoryArray = Restaurant.Greek;
        }
        else if(categoryName.equals(Restaurant.Italian[0].getCategory())){
            categoryArray = Restaurant.Italian;
        }
        else{
        //if (categoryName.equals(Restaurant.Japanese[0].getCategory())){
            categoryArray = Restaurant.Japanese;
        }

        //generate restaurant spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
            //create an ArrayAdapter using the string array and a dfault spinner layout
        ArrayAdapter<Restaurant> adapter = new ArrayAdapter<Restaurant>(this,android.R.layout.simple_spinner_item, categoryArray);
            // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    //when click next button, the page change to Menu
    public void onClickNext(View v){
        //get value from spinner
        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
        String restaurant = mySpinner.getSelectedItem().toString();

        //get menu array
        for(int i = 0; i < categoryArray.length; i++ ){
            if(restaurant.equals(categoryArray[i].getName())){
                menu = categoryArray[i].getMenu();
                break;
            }
        }

        Intent intent = new Intent(RestaurantActivity.this, MenuActivity.class);
        intent.putExtra("restaurant", restaurant);
        intent.putExtra("menu", menu);
        startActivity(intent);
    }

}
