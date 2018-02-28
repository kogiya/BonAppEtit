package com.georgebrown.comp3074.a1100984638;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Owner on 9/30/2017.
 */

public class Validation {

    public Validation(){};

    //to check if the postal code is valid (canadian)
    public static boolean validPostalCode(String postalCode){
        String regex = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(postalCode);
            return matcher.matches();
    }

    //to check if the credit card number is valid(visa, mastercard, americanExpress)
    public static boolean validCreditCard(String cardNum){
        //credit card regex
        String visa = "^4[0-9]{12}(?:[0-9]{3})?$";
        String mastercard = "^5[1-5][0-9]{14}$";
        String amex = "^3[47][0-9]{13}$";

        //compile regex pattern
        Pattern visaPattern = Pattern.compile(visa);
        Pattern mastercardPattern = Pattern.compile(mastercard);
        Pattern amexPattern = Pattern.compile(amex);

        //Match the card
        Matcher visaMatcher = visaPattern.matcher(cardNum);
        Matcher mastercardMatcher = mastercardPattern.matcher(cardNum);
        Matcher amexMatcher = amexPattern.matcher(cardNum);

        if(visaMatcher.matches()){
            return true;
        }else if(mastercardMatcher.matches()){
            return true;
        }else if(amexMatcher.matches()){
            return true;
        }
        else
            return false;
    }

}
