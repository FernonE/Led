import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';

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
  GreenLed0Status: boolean
  YellowLed0Status: boolean
  YellowLed1Status: boolean
  RedLed0Status: boolean
  RedLed1Status: boolean


  ngOnInit() {
    setInterval(() => {
      this.CheckLeds()
    },100)
  }

  constructor(private appService: AppService) { }

  CheckLeds() {
    this.appService.GetGreenLed0().subscribe(x => {
      this.GreenLed0Status = x;
      (<HTMLInputElement>document.getElementById("GreenLed0")).checked = this.GreenLed0Status;
    })
    this.appService.GetYellowLed0().subscribe(x => {
      this.YellowLed0Status = x;
      (<HTMLInputElement>document.getElementById("YellowLed0")).checked = this.YellowLed0Status;
    })
    this.appService.GetYellowLed1().subscribe(x => {
      this.YellowLed1Status = x;
      (<HTMLInputElement>document.getElementById("YellowLed1")).checked = this.YellowLed1Status;
    })
    this.appService.GetRedLed0().subscribe(x => {
      this.RedLed0Status = x;
      (<HTMLInputElement>document.getElementById("RedLed0")).checked = this.RedLed0Status;
    })
    this.appService.GetRedLed1().subscribe(x => {
      this.RedLed1Status = x;
      (<HTMLInputElement>document.getElementById("RedLed1")).checked = this.RedLed1Status;
    })
  }

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

 

