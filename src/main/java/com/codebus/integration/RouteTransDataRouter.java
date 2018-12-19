package com.codebus.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
//import org.springframework.messaging.MessageChannel;

import com.codebus.domain.MtsTranDataEnvelope;

@MessageEndpoint
public class RouteTransDataRouter {

	// Routes based on destination country
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
//		System.out.println("Money transfering out to: " + destination);
		return destination;

	}

	// Routes to one of the US banks
	@Router(inputChannel = "usChannel")
	public String routeToUsBanks(MtsTranDataEnvelope txData) {
//		String destination = null;

		return "usBankOneChannel"; // "usBankOneChannel" or "usBankTwoChannel"

	}

	// Routes to one of the Mongolian banks
	@Router(inputChannel = "mnChannel")
	public String routeToMongolianBanks(MtsTranDataEnvelope txData) {

		return "mnBankOneChannel";

	}

	// Routes to one of the Ethiopian banks
	@Router(inputChannel = "etChannel")
	public String routeToEthiopianBanks(MtsTranDataEnvelope txData) {

		return "etBankOneChannel";

	}

}
