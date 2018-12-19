package com.codebus.domain;

import java.io.Serializable;

public class MtsTranDataEnvelope implements Serializable{	
	
	private static final long serialVersionUID = 1L;

	public enum RouteTranDataType {USA, MONGOLIA, ETHIOPIA, ERROR}
	
	private TranData tranData;
	
	private RouteTranDataType routeTranDataType;
	
	public MtsTranDataEnvelope() {}
	
	public MtsTranDataEnvelope(TranData tranData, RouteTranDataType routeTranDataType) {
		this.tranData = tranData;
		this.routeTranDataType = routeTranDataType;
	}

    public TranData getTranData() {
		return tranData;
	}

	public RouteTranDataType getRouteTranType() {
		return routeTranDataType;
	}

}
