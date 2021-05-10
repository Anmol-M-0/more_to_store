package com.app.utils;

public interface CardUtils {

	static void validateForm(String cardname, String cardnumber, String expmonth, String expyear) {
		if(cardname.length()>40 || cardnumber.length()>20 || expmonth.length()>30 || expyear.length()>50)
			throw new RuntimeException("the card details are not valid");
		
	}

}
