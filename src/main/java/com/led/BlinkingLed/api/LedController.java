package com.led.BlinkingLed.api;

import com.pi4j.io.gpio.PinState;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.led.BlinkingLed.BlinkingLedApplication.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/led")
public class LedController {

    /* Checking status of led */

    @GetMapping("/greenLed0")
    public static boolean greenLed0 () {
        if (getGreenLed0().getState() == PinState.HIGH) return true;
        else return false;
    }


    /* turning the leds on and off */
    @GetMapping("/greenLed0/On")
    public static void greenLed0On (){
        getGreenLed0().high();
    }

    @GetMapping("/greenLed0/Off")
    public static void greenLed0Off () {
        getGreenLed0().low();
    }

    @GetMapping("/yellowLed0/On")
    public static void yellowLed0On (){
        getYellowLed0().high();
    }

    @GetMapping("/yellowLed0/Off")
    public static void yellowLed0Off () {
        getYellowLed0().low();
    }

    @GetMapping("/yellowLed1/On")
    public static void yellowLed1On (){
        getYellowLed1().high();
    }

    @GetMapping("/yellowLed1/Off")
    public static void yellowLed1Off () {
        getYellowLed1().low();
    }

    @GetMapping("/redLed0/On")
    public static void redLed0On (){
        getRedLed0().high();
    }

    @GetMapping("/redLed0/Off")
    public static void redLed0Off () {
        getRedLed0().low();
    }

    @GetMapping("/redLed1/On")
    public static void redLed1On (){
        getRedLed1().high();
    }

    @GetMapping("/redLed1/Off")
    public static void redLed1Off () {
        getRedLed1().low();
    }

    /* toggling the leds */
    @GetMapping("/greenLed0/toggle")
    public static void greenLed0Toggle () {
        getGreenLed0().toggle();
    }

    @GetMapping("/yellowLed0/toggle")
    public static void yellowLed0Toggle () {
        getYellowLed0().toggle();
    }

    @GetMapping("/yellowLed1/toggle")
    public static void yellowLed1Toggle () {
        getYellowLed1().toggle();
    }

    @GetMapping("/redLed0/toggle")
    public static void redLed0Toggle () {
        getRedLed0().toggle();
    }

    @GetMapping("/redLed1/toggle")
    public static void redLed1Toggle () {
        System.out.println("in redled1 toggle in java");
        getRedLed1().toggle();
    }



    /* Turning on and off all */
    @GetMapping("/AllOn")
    public static void allOn (){
        greenLed0On();
        yellowLed0On();
        yellowLed1On();
        redLed0On();
        redLed1On();
    }

    @GetMapping("/AllOff")
    public static void allOff () {
        greenLed0Off();
        yellowLed0Off();
        yellowLed1Off();
        redLed0Off();
        redLed1Off();
    }
}
