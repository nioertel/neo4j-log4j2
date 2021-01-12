package com.example.neo4j.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class LoggingTest {

	private final Logger logger = LogManager.getLogger(LoggingTest.class);

	@Test
	void logMessageShouldBePrintedToConsole() {
		logger.info("Hello World.");
	}
}
