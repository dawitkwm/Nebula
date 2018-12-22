package com.codebus.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.codebus.domain.MtsTranDataEnvelope;
import com.codebus.domain.MtsTranDataEnvelope.TranDataBankType;

//Routes to one of the Mongolian banks
@MessageEndpoint
public class MongolianBanksRouter {
	@Router(inputChannel = "mnChannel")
	public String routeToMongolianBanks(MtsTranDataEnvelope txData) {
		if (txData.getTranDataBankType().equals(TranDataBankType.MONGOLIANBANKONE)) {
			return "mnBankOneChannel";
		} else {
			return "noBankChannel";
		}
	}
}

