import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { booleanReturn } from './booleanReturn';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LedWebsite';

  countdown: number = 11
  timer: number = this.countdown
  countdownStarted: boolean = false
  timeoutSentence: string
  booleanLed: booleanReturn


  ngOnInit() {
    this.appService.GetGreenLed0().subscribe(x => {
      this.booleanLed = x
      console.log("printing booleanLed")
      console.log(this.booleanLed)
      console.log(x)
    })
      

    if (this.appService.GetGreenLed0().subscribe()) {
      (<HTMLInputElement>document.getElementById("GreenLed0")).checked = false;
    }

  }

  constructor(private appService: AppService) { }

  ToggleGreenLed0() {
    console.log("toggle Green led 0")
    this.appService.ServiceToggleGreenLed0().subscribe()
    this.resetLed()
  }

  ToggleYellowLed0() {
    console.log("toggle Yellow led 0")
    this.appService.ServiceToggleYellowLed0().subscribe()
    this.resetLed()
  }

  ToggleYellowLed1() {
    console.log("toggle Yellow led 1")
    this.appService.ServiceToggleYellowLed1().subscribe()
    this.resetLed()
  }

  ToggleRedLed0() {
    console.log("toggle red led 0")
    this.appService.ServiceToggleRedLed0().subscribe()
    this.resetLed()
  }

  ToggleRedLed1() {
    console.log("toggle red led 1")
    this.appService.ServiceToggleRedLed1().subscribe()
    this.resetLed()
  }

  resetLed() {
    this.timer = this.countdown
    if (this.countdownStarted) {
      this.timer = this.countdown
    }
    else {
      let intervalId = setInterval(() => {
        this.countdownStarted = true;
        this.timer = this.timer - 1;
        this.timeoutSentence = `Turning all leds off in ${this.timer} seconds`
        if (this.timer <= 0) {
          this.countdownStarted = false
          this.timeoutSentence = ''
          this.appService.ServiceTurnOffAll().subscribe();
          (<HTMLInputElement>document.getElementById("GreenLed0")).checked = false;
          (<HTMLInputElement>document.getElementById("YellowLed0")).checked = false;
          (<HTMLInputElement>document.getElementById("YellowLed1")).checked = false;
          (<HTMLInputElement>document.getElementById("RedLed0")).checked = false;
          (<HTMLInputElement>document.getElementById("RedLed1")).checked = false;
          clearInterval(intervalId)
          }
      }, 1000)
    }
  }
}

 

