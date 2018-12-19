 
package com.codebus.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import com.codebus.domain.MtsTranDataEnvelope;
import com.codebus.domain.TranData;
import com.codebus.domain.MtsTranDataEnvelope.RouteTranDataType;

@MessageEndpoint
public class TransactionDataTransformerImpl implements TransactionDataTransformer {

    
    //Transform TranData to CountryCodeTranData based on destination country code
	@Transformer(inputChannel="txDataCh", outputChannel="routeTxDataCh")
	public MtsTranDataEnvelope transformTranData(TranData tranData) {
 
		MtsTranDataEnvelope countryRouteTranData = null;
 		if(tranData.getToIBAN().substring(0, 2).equals("us")) {
 			countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.USA);
 		} else if(tranData.getToIBAN().substring(0, 2).equals("mn")){
 			countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.MONGOLIA);
 		} else if(tranData.getToIBAN().substring(0, 2).equals("et")){
 			countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.ETHIOPIA);
 		} else {
 			countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.ERROR);
 		}
	    	 	
		return countryRouteTranData;
	}

}
