package com.georgebrown.comp3074.a1100984638;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when click enter button, the page change to Category
    public void onClickEnter(View v){
        Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
        startActivity(intent);
    }
}
