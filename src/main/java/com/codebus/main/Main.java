package com.codebus.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

	private final static String[] mtsConfigFiles = {
			"/META-INF/spring/integration/mts-common-context.xml",
			"/META-INF/spring/integration/mts-direct-exchanges-and-queues.xml",
			"/META-INF/spring/integration/mts-banks-integration-bus.xml",
			"/META-INF/spring/integration/mts-direct-queue-listener-context.xml" 
	};

	public static void main(String[] args) {
		System.out.println(
				  "\n======================================================================"
				+ "\n                                                         "
				+ "\n    Started Guivulga - The Next Generation Money Transfer Service!"
				+ "\n                                                         "
				+ "\n======================================================================");

		System.out.println();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(mtsConfigFiles, Main.class);

		applicationContext.getBean(Main.class).mainInternal(applicationContext);
		
	}

	private void mainInternal(ApplicationContext applicationContext) {
		// wait for messages
	}
	
}
