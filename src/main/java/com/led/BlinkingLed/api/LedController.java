package com.led.BlinkingLed.api;

import com.pi4j.io.gpio.*;
import com.mgnt.utils.TimeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
        TimeUtils.sleepFor(200, TimeUnit.MILLISECONDS);
        pin.high();
        TimeUtils.sleepFor(2000, TimeUnit.MILLISECONDS);
        pin.low();
        TimeUtils.sleepFor(200, TimeUnit.MILLISECONDS);
        pin.high();

        System.out.println("Done");
        return "Turned led on";
    }

    @GetMapping("/off")
    public String ledoff (){
        System.out.println("Turning led off");
        if (pin == null){
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "greenLed", PinState.LOW);
        }

        pin.low();

        System.out.println("Done");
        return "Turned led off";
    }
}
