package com.codebus.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.codebus.domain.MtsTranDataEnvelope;


@Aspect
@Component
public class MtsLoggingAspect {

	@Pointcut("within(com.codebus.integration) && args(mtsTxData) ")
	public void integrationMethodWithMtsTxDataArg() {
	}

	// An advice with a MtsTranDataEnvelope parameter
	@After("integrationMethodWithMtsTxDataArg(mtsTxData)")
	public void logWhereMoneyIsGoing(JoinPoint joinPoint, MtsTranDataEnvelope mtsTxData) {
		System.out.println("Transfering money to " + mtsTxData.getRouteTranType());
	}

}
