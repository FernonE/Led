package com.led.BlinkingLed.api;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/led")
public class LedController {

    private static GpioPinDigitalOutput pin;


    @GetMapping("/on")
    public void ledOn (){
        System.out.println("Turning led on");
        if (pin == null){
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_18, "greenLed", PinState.LOW);
        }

        pin.high();

        System.out.println("Done");

    }

    @GetMapping("/off")
    public void ledof (){
        System.out.println("Turning led off");
        if (pin == null){
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_18, "greenLed", PinState.LOW);
        }

        pin.low();

        System.out.println("Done");

    }
}
