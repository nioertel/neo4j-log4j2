package com.example.neo4j.log4j2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neo4j.logging.shaded.log4j.LogManager;

class LoggingTest {

	private PrintStream originaStandardOut;
	private ByteArrayOutputStream standardOutCapture;

	@BeforeEach
	void configureCaptures() {
		originaStandardOut = System.out;
		standardOutCapture = new ByteArrayOutputStream();
		System.setOut(new PrintStream(new OutputStream() {

			@Override
			public void write(int b) throws IOException {
				originaStandardOut.write(b);
				standardOutCapture.write(b);
			}
		}));
	}

	@AfterEach
	void clearCaptures() throws IOException {
		System.setOut(originaStandardOut);
		standardOutCapture.close();
	}

	@Test
	void logMessageShouldBePrintedToConsole() {
		LogManager.getLogger(LoggingTest.class).info("Hello World.");

		String consoleOutput = standardOutCapture.toString(StandardCharsets.UTF_8);
		Assertions.assertEquals(
				"[main] INFO  com.example.neo4j.log4j2.LoggingTest - Hello World." + System.lineSeparator(),
				consoleOutput);
	}
}
