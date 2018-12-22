package com.codebus.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.codebus.domain.MtsTranDataEnvelope;
import com.codebus.domain.MtsTranDataEnvelope.TranDataBankType;

//Routes to one of the Ethiopian banks
@MessageEndpoint
public class EthiopianBanksRouter {
	@Router(inputChannel = "etChannel")
	public String routeToEthiopianBanks(MtsTranDataEnvelope txData) {
		if (txData.getTranDataBankType().equals(TranDataBankType.ETHIOPIANBANKONE)) {
			return "etBankOneChannel";
		} else {
			return "noBankChannel";
		}
	}
}
