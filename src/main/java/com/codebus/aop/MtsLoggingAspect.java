package com.codebus.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.codebus.domain.MtsTranDataEnvelope;


@Aspect
@Component
public class MtsLoggingAspect {

	@After("within(com.codebus.integration.CountryRouter) && args(mtsTxData) ")
	public void logWhereMoneyIsGoing(JoinPoint joinPoint, MtsTranDataEnvelope mtsTxData) {
		System.out.println("Transfering money to " + mtsTxData.getRouteTranType());
	}

}
