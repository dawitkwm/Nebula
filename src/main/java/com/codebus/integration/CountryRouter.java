package com.codebus.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.codebus.domain.MtsTranDataEnvelope;

//Routes based on destination country
@MessageEndpoint
public class CountryRouter {
	@Router(inputChannel = "routeTxDataCh")
	public String routeTransDataByCountry(MtsTranDataEnvelope mtsTxData) {
		String destination = null;
		switch (mtsTxData.getRouteTranType()) {
		case USA:
			destination = "usChannel";
			break;
		case MONGOLIA:
			destination = "mnChannel";
			break;
		case ETHIOPIA:
			destination = "etChannel";
			break;
		case ERROR:
			destination = "noCountryChannel";
			break;
		}
//		System.out.println("Routing money transfer to: " + destination);
		return destination;

	}
}