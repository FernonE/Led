package com.led.BlinkingLed;

import com.pi4j.io.gpio.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlinkingLedApplication {

	private static GpioPinDigitalOutput greenLed0;
	private static GpioPinDigitalOutput yellowLed0;
	private static GpioPinDigitalOutput yellowLed1;
	private static GpioPinDigitalOutput redLed0;
	private static GpioPinDigitalOutput redLed1;

	public static void main(String[] args) {
		SpringApplication.run(BlinkingLedApplication.class, args);

		GpioController gpioController = GpioFactory.getInstance();
		greenLed0 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "greenLed0", PinState.LOW);
		yellowLed0 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "yellowLed0", PinState.LOW);
		yellowLed0 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05, "yellowLed1", PinState.LOW);
		redLed0 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_06, "redLed0", PinState.LOW);
		redLed1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_10, "redLed1", PinState.LOW);
	}


	/* ---------- Getters and Setters ---------- */
	public static GpioPinDigitalOutput getGreenLed0() {
		return greenLed0;
	}

	public static void setGreenLed0(GpioPinDigitalOutput greenLed0) {
		BlinkingLedApplication.greenLed0 = greenLed0;
	}

	public static GpioPinDigitalOutput getYellowLed0() {
		return yellowLed0;
	}

	public static void setYellowLed0(GpioPinDigitalOutput yellowLed0) {
		BlinkingLedApplication.yellowLed0 = yellowLed0;
	}

	public static GpioPinDigitalOutput getYellowLed1() {
		return yellowLed1;
	}

	public static void setYellowLed1(GpioPinDigitalOutput yellowLed1) {
		BlinkingLedApplication.yellowLed1 = yellowLed1;
	}

	public static GpioPinDigitalOutput getRedLed0() {
		return redLed0;
	}

	public static void setRedLed0(GpioPinDigitalOutput redLed0) {
		BlinkingLedApplication.redLed0 = redLed0;
	}

	public static GpioPinDigitalOutput getRedLed1() {
		return redLed1;
	}

	public static void setRedLed1(GpioPinDigitalOutput redLed1) {
		BlinkingLedApplication.redLed1 = redLed1;
	}
}
