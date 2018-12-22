package com.codebus.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.codebus.domain.MtsTranDataEnvelope;
import com.codebus.domain.MtsTranDataEnvelope.TranDataBankType;

//Routes to one of the US banks
@MessageEndpoint
public class USBanksRouter {
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
}
