package com.codebus.domain;

import java.io.Serializable;

public class MtsTranDataEnvelope implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	public enum RouteTranDataType {USA, MONGOLIA, ETHIOPIA, ERROR}
	
	public enum TranDataBankType {USBANKONE, USBANKTWO, MONGOLIANBANKONE, ETHIOPIANBANKONE, ERROR}
	
	private TranData tranData;
	
	private RouteTranDataType routeTranDataType;
	
	private TranDataBankType tranDataBankType;
	
	public MtsTranDataEnvelope() {}
	
	public MtsTranDataEnvelope(TranData tranData, RouteTranDataType routeTranDataType, TranDataBankType tranDataBankType) {
		this.tranData = tranData;
		this.routeTranDataType = routeTranDataType;
		this.tranDataBankType = tranDataBankType;
	}

    public TranData getTranData() {
		return tranData;
	}

	public RouteTranDataType getRouteTranType() {
		return routeTranDataType;
	}

	public TranDataBankType getTranDataBankType() {
		return tranDataBankType;
	}
	
}
