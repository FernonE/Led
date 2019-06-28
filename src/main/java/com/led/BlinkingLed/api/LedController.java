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
    public String ledOn (){
        System.out.println("Turning led on");
        if (pin == null){
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "greenLed", PinState.LOW);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        pin.high();

        System.out.println("Done");
        return "Turnin led on in 2 seconds";
    }

    @GetMapping("/off")
    public String ledoff (){
        System.out.println("Turning led off");
        if (pin == null){
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "greenLed", PinState.LOW);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
        pin.low();

        System.out.println("Done");
        return "Turnin led off in 2 seconds";
    }
}
