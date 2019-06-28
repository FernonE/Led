package com.led.BlinkingLed.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.led.BlinkingLed.BlinkingLedApplication.*;

@RestController
@RequestMapping("/led")
public class LedController {


    @GetMapping("/greenLed0/On")
    public void greenLed0On (){
        getGreenLed0().high();
    }

    @GetMapping("/greenLed0/Off")
    public void greenLed0Off () {
        getGreenLed0().low();
    }

    @GetMapping("/yellowLed0/On")
    public void yellowLed0On (){
        getYellowLed0().high();
    }

    @GetMapping("/yellowLed0/Off")
    public void yellowLed0Off () {
        getYellowLed0().low();
    }

    @GetMapping("/yellowLed1/On")
    public void yellowLed1On (){
        getYellowLed1().high();
    }

    @GetMapping("/yellowLed1/Off")
    public void yellowLed1Off () {
        getYellowLed1().low();
    }

    @GetMapping("/redLed0/On")
    public void redLed0On (){
        getRedLed0().high();
    }

    @GetMapping("/redLed0/Off")
    public void redLed0Off () {
        getRedLed0().low();
    }

    @GetMapping("/redLed1/On")
    public void redLed1On (){
        getRedLed1().high();
    }

    @GetMapping("/redLed1/Off")
    public void redLed1Off () {
        getRedLed1().low();
    }

    @GetMapping("/AllOn")
    public void allOn (){
        greenLed0On();
        yellowLed0On();
        yellowLed1On();
        redLed0On();
        redLed1On();
    }

    @GetMapping("/AllOff")
    public void allOff () {
        greenLed0Off();
        yellowLed0Off();
        yellowLed1Off();
        redLed0Off();
        redLed1Off();
    }
}
