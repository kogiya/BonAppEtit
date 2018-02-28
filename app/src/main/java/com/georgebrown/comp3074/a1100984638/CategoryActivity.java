package com.georgebrown.comp3074.a1100984638;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity {

    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category = "Mexican";//default value of radio button
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

         // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbMexican:
                if (checked)
                    category = "Mexican";
                break;
            case R.id.rbCaribbean:
                if (checked)
                    category = "Caribbean";
                break;
            case R.id.rbGreek:
                if (checked)
                    category = "Greek";
                break;
            case R.id.rbItalian:
                if (checked)
                    category = "Italian";
                break;
            case R.id.rbJapanese:
                if (checked)
                    category = "Japanese";
                break;
        }
    }

    //when click next button, the page change to Restaurant
    public void onClickNext(View v){
            Intent intent = new Intent(CategoryActivity.this, RestaurantActivity.class);
            intent.putExtra("category", category);
            startActivity(intent);
    }

}
