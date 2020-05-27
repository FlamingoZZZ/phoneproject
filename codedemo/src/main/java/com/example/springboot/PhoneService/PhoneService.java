package com.example.springboot.PhoneService;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.springboot.exception.InvalidPhoneNumberException;


@Service
public class PhoneService {
	
	static Map<String, String> phoneMap = new HashMap<String, String> (){
		{
			put("1", "1");
			put("2", "2abc");
			put("3", "3def");
			put("4", "4ghi");
			put("5", "5jkl");
			put("6", "6mno");
			put("7", "7pqrs");
			put("8", "8tuv");
			put("9", "9wxyz");
			put("0", "0");
		}
	};
	
	public static String regexStr7 = "^[0-9]{7}$";
	public static String regexStr10 = "^[0-9]{10}$";

	public List<String> getAllResults(String phonenumber) {
		
		if(!phonenumber.matches(regexStr7) && !phonenumber.matches(regexStr10)) {
			throw new InvalidPhoneNumberException("Input validated phone number!");
		}
		
		List<String> output = new ArrayList<String>();
		
		if (phonenumber.length() != 0) {
			combination("", phonenumber,phoneMap,output);
		}
		      
		    return output;
	
		
	}
	
	private void combination(String cmb, String next_digits, Map<String, String> phoneMap, List<String> output ) {
	   
	    if (next_digits.length() == 0) {
	      
	      output.add(cmb);
	    }
	    
	    else {
	    	String digit = next_digits.substring(0, 1);
	    	String letters = phoneMap.get(digit);
	    	for (int i = 0; i < letters.length(); i++) {
	    		
	    		String letter = phoneMap.get(digit).substring(i, i + 1);
	    		combination(cmb + letter, next_digits.substring(1), phoneMap, output);
	      }
	    }
	  }

}
