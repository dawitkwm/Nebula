
package com.codebus.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;

import com.codebus.domain.MtsTranDataEnvelope;
import com.codebus.domain.TranData;
import com.codebus.domain.MtsTranDataEnvelope.RouteTranDataType;
import com.codebus.domain.MtsTranDataEnvelope.TranDataBankType;

@MessageEndpoint
public class TransactionDataTransformerImpl implements TransactionDataTransformer {

    
    //Transform TranData to CountryCodeTranData based on destination country code
	@Transformer(inputChannel="txDataCh", outputChannel="routeTxDataCh")
	public MtsTranDataEnvelope transformTranData(TranData tranData) {
 
		MtsTranDataEnvelope countryRouteTranData = null;
		String countryCode = tranData.getToIBAN().substring(0, 2);
		String bankCode = tranData.getToIBAN().substring(3, 10);
		System.out.println("Country code: " + countryCode);
		System.out.println("Bank code: " + bankCode);
 		if(countryCode.equals("us") && bankCode.equals("bankone")) {
				countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.USA, TranDataBankType.USBANKONE);

 		} else if(countryCode.equals("us") && bankCode.equals("banktwo")) {
				countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.USA, TranDataBankType.USBANKTWO);
		} else if(countryCode.equals("mn") && bankCode.equals("bankone")) {
				countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.MONGOLIA, TranDataBankType.MONGOLIANBANKONE);
		} else if(countryCode.equals("et") && bankCode.equals("bankone")) {
			countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.ETHIOPIA, TranDataBankType.ETHIOPIANBANKONE);
		} else {
 			countryRouteTranData = new MtsTranDataEnvelope(tranData, RouteTranDataType.ERROR, TranDataBankType.ERROR);
 		}
	    	 	
		return countryRouteTranData;
	}

}
