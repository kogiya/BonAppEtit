package com.georgebrown.comp3074.a1100984638;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Owner on 9/29/2017.
 */

public class CustomerActivity extends AppCompatActivity {

    ArrayList<String> orderArray;

    Button nextButton;
    EditText fName;
    EditText lName;
    EditText address;
    EditText postalCode;
    EditText creditNo;
    EditText cuisine;
    EditText restaurant;

    String txtFName;
    String txtLName;
    String txtAddress;
    String txtPostalCode;
    String txtCreditNo;
    String txtCuisine;
    String txtRestaurant;

    Customer customer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        //Get ordered menu array from the intent
        Intent intent = getIntent();
        orderArray = intent.getStringArrayListExtra("order");//order array
    }

    public void onClickOrder(View v){
        //get value from edit text
        fName = (EditText) findViewById(R.id.editFName);
        lName = (EditText) findViewById(R.id.editLName);
        address = (EditText) findViewById(R.id.editAddress);
        postalCode = (EditText) findViewById(R.id.editPostalCode);
        creditNo = (EditText) findViewById(R.id.editCreditNo);
        cuisine = (EditText) findViewById(R.id.editCuisine);
        restaurant = (EditText) findViewById(R.id.editRestaurant);

        //change the value from edit text to String
        txtFName = fName.getText().toString();
        txtLName = lName.getText().toString();
        txtAddress = address.getText().toString();
        txtPostalCode = postalCode.getText().toString();
        txtCreditNo = creditNo.getText().toString();
        txtCuisine = cuisine.getText().toString();
        txtRestaurant = restaurant.getText().toString();

        //store string value to customer class to pass the value to checkout activity
        customer = new Customer(txtFName, txtLName, txtAddress, txtPostalCode, txtCreditNo, txtCuisine, txtRestaurant);


        //validate user input
        //if customer information is empty
        if(isEmpty(txtFName) || isEmpty(txtLName) || isEmpty(txtAddress) || isEmpty(txtPostalCode) || isEmpty(txtCreditNo)){
            Toast.makeText(CustomerActivity.this,"Please fill out all customer information.", Toast.LENGTH_LONG).show();
        }
        else if(!txtPostalCode.equals(txtPostalCode.toUpperCase())){
            Toast.makeText(CustomerActivity.this,"Please use ONLY capital letters and numbers for postal code.", Toast.LENGTH_LONG).show();
        }
        else if(!Validation.validPostalCode(txtPostalCode)){
            Toast.makeText(CustomerActivity.this,"Postal Code is invalid.", Toast.LENGTH_LONG).show();
        }
        else if(!Validation.validCreditCard(txtCreditNo)){
            Toast.makeText(CustomerActivity.this,"Credit Card Number is invalid.\n We take only Visa, Master Card and American Express.", Toast.LENGTH_LONG).show();
        }
        else{

            //when click next order button, the page change to Checkout
            Intent intent = new Intent(CustomerActivity.this, CheckoutActivity.class);
            intent.putExtra("order", orderArray);//menu
            intent.putExtra("custInfo", customer);//customer information
            startActivity(intent);
        }
    }

}
