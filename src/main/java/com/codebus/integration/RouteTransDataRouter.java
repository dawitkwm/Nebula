package com.codebus.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
//import org.springframework.messaging.MessageChannel;

import com.codebus.domain.MtsTranDataEnvelope;
import com.codebus.domain.MtsTranDataEnvelope.TranDataBankType;

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
//		System.out.println("Routing money transfer to: " + destination);
		return destination;

	}

	// Routes to one of the US banks
	@Router(inputChannel = "usChannel")
	public String routeToUsBanks(MtsTranDataEnvelope txData) {
		if (txData.getTranDataBankType().equals(TranDataBankType.USBANKONE)) {
			return "usBankOneChannel";
		} else if (txData.getTranDataBankType().equals(TranDataBankType.USBANKTWO)) {
			return "usBankTwoChannel";
		} else {
			return "noBankChannel";
		}

	}

	// Routes to one of the Mongolian banks
	@Router(inputChannel = "mnChannel")
	public String routeToMongolianBanks(MtsTranDataEnvelope txData) {

		if (txData.getTranDataBankType().equals(TranDataBankType.MONGOLIANBANKONE)) {
			return "mnBankOneChannel";
		} else {
			return "noBankChannel";
		}

	}

	// Routes to one of the Ethiopian banks
	@Router(inputChannel = "etChannel")
	public String routeToEthiopianBanks(MtsTranDataEnvelope txData) {
		if (txData.getTranDataBankType().equals(TranDataBankType.ETHIOPIANBANKONE)) {
			return "etBankOneChannel";
		} else {
			return "noBankChannel";
		}
		
	}

}
