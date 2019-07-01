package com.led.BlinkingLed.model;


import com.led.BlinkingLed.api.LedController;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;

public class PinModel {

    private static GpioPinDigitalOutput greenLed0;
    private static GpioPinDigitalOutput yellowLed0;
    private static GpioPinDigitalOutput yellowLed1;
    private static GpioPinDigitalOutput redLed0;
    private static GpioPinDigitalOutput redLed1;
    private static GpioPinDigitalInput button;

    public static void main(String[] args) {

        GpioController gpioController = GpioFactory.getInstance();
        greenLed0 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "greenLed0", PinState.LOW);
        yellowLed0 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_04, "yellowLed0", PinState.LOW);
        yellowLed1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_05, "yellowLed1", PinState.LOW);
        redLed0 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_06, "redLed0", PinState.LOW);
        redLed1 = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_10, "redLed1", PinState.LOW);

        button = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_27, "button",PinPullResistance.PULL_DOWN);
        button.addTrigger(new GpioSetStateTrigger(PinState.HIGH,redLed0,PinState.HIGH));
        button.addTrigger(new GpioSetStateTrigger(PinState.LOW,redLed0,PinState.LOW));

        // create and register gpio pin listener
        button.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
            }
        });




        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                LedController.allOff();
            }
        });


    }

    /* ---------- Getters and Setters ---------- */
    public static GpioPinDigitalOutput getGreenLed0() {
        return greenLed0;
    }

    public static void setGreenLed0(GpioPinDigitalOutput greenLed0) {
        PinModel.greenLed0 = greenLed0;
    }

    public static GpioPinDigitalOutput getYellowLed0() {
        return yellowLed0;
    }

    public static void setYellowLed0(GpioPinDigitalOutput yellowLed0) {
        PinModel.yellowLed0 = yellowLed0;
    }

    public static GpioPinDigitalOutput getYellowLed1() {
        return yellowLed1;
    }

    public static void setYellowLed1(GpioPinDigitalOutput yellowLed1) {
        PinModel.yellowLed1 = yellowLed1;
    }

    public static GpioPinDigitalOutput getRedLed0() {
        return redLed0;
    }

    public static void setRedLed0(GpioPinDigitalOutput redLed0) {
        PinModel.redLed0 = redLed0;
    }

    public static GpioPinDigitalOutput getRedLed1() {
        return redLed1;
    }

    public static void setRedLed1(GpioPinDigitalOutput redLed1) {
        PinModel.redLed1 = redLed1;
    }
}
