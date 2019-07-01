package com.led.BlinkingLed;

import com.led.BlinkingLed.api.LedController;
import com.pi4j.io.gpio.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlinkingLedApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlinkingLedApplication.class, args);
	}



}
