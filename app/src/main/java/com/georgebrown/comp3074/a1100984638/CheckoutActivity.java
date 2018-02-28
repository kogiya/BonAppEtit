package com.georgebrown.comp3074.a1100984638;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheckoutActivity extends AppCompatActivity {

    private ListView orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_checkout);

        //Get ordered menu array and customer information from the intent
        Intent intent = getIntent();
        ArrayList<String> orderArray = intent.getStringArrayListExtra("order");//order array(contains duplicate)
        Set<String> hs = new HashSet<>();
        hs.addAll(orderArray);
        orderArray.clear();
        orderArray.addAll(hs); // delete duplicates
        Customer customer = (Customer)intent.getSerializableExtra("custInfo");//customer information

        //display order items
        TextView orderText = (TextView)findViewById(R.id.txtOrder);
        String orderItems = "";
     //use for each version
/*        for(String item: orderArray){

            orderText.append(item);
            orderText.append("\n");
        }
*/
       //use for loop version
        for(int i = 0; i < orderArray.size(); i++){

            orderItems += orderArray.get(i) + "\n";
        }
        orderText.setText(orderItems);


        //display customer information from customer activity
        TextView fName = (TextView)findViewById(R.id.txtFName);
        fName.setText(customer.getFirstName());

        TextView lName = (TextView)findViewById(R.id.txtLName);
        lName.setText(customer.getLastName());

        TextView address = (TextView)findViewById(R.id.txtAddress);
        address.setText(customer.getAddress());

        TextView postalCode = (TextView)findViewById(R.id.txtPostalCode);
        postalCode.setText(customer.getPostalCode());

        TextView creditNo = (TextView)findViewById(R.id.txtCreditNo);
        creditNo.setText(customer.getCreditNo());

        TextView cuisine = (TextView)findViewById(R.id.txtCuisine);
        cuisine.setText(customer.getCuisine());

        TextView restaurant = (TextView)findViewById(R.id.txtRestaurant);
        restaurant.setText(customer.getRestaurant());

    }

    public void onClickConfirm(View v){
        Toast.makeText(CheckoutActivity.this,"Thank you for using \"Bon appetit!\"", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(CheckoutActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
