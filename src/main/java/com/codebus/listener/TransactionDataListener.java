package com.codebus.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codebus.domain.TranData;


public class TransactionDataListener {
    private static final Logger logger = LoggerFactory.getLogger(TransactionDataListener.class);

    
    public void listen(TranData tranData) {
    	//TODO implement this as AOP
    	System.out.println("Received Money to Be Transfered: ");
    	System.out.println("Destination Country: " + countryCodeToName(tranData.getToIBAN().substring(0, 2)));
    	System.out.println("Destination bank name: " + tranData.getBankName());
    	System.out.println("Amount: " + tranData.getAmount());
    }
    
    private String countryCodeToName(String countryCode) {
    	String countryName = null;
    	if(countryCode.equals("us")) {
    		countryName  = "USA";
    	} else if (countryCode.equals("mn")) {
    		countryName  = "MONGOLIA";
    	} else if (countryCode.equals("et")) {
    		countryName  = "ETHIOPIA";
    	} 
    	return countryName;
    }
}
