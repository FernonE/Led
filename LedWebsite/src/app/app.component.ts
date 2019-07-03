import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LedWebsite';

  countdown: number = 30
  timer: number = this.countdown
  counter: number = this.countdown
  timeoutSentence: string
  booleanLed


  ngOnInit() {
    this.appService.GetGreenLed0().subscribe(booleanLed => this.booleanLed = booleanLed)
    console.log(this.booleanLed)

    if (this.appService.GetGreenLed0().subscribe()) {
      (<HTMLInputElement>document.getElementById("GreenLed0")).checked = true;
    }

  }

  constructor(private appService: AppService) { }

  ToggleGreenLed0() {
    console.log("toggle Green led 0")
    this.appService.ServiceToggleGreenLed0().subscribe()
    this.resetLed(this.counter)
  }

  ToggleYellowLed0() {
    console.log("toggle Yellow led 0")
    this.appService.ServiceToggleYellowLed0().subscribe()
    this.resetLed(this.counter)
  }

  ToggleYellowLed1() {
    console.log("toggle Yellow led 1")
    this.appService.ServiceToggleYellowLed1().subscribe()
    this.resetLed(this.counter)
  }

  ToggleRedLed0() {
    console.log("toggle red led 0")
    this.appService.ServiceToggleRedLed0().subscribe()
    this.resetLed(this.counter)
  }

  ToggleRedLed1() {
    console.log("toggle red led 1")
    this.appService.ServiceToggleRedLed1().subscribe()
    this.resetLed(this.counter)
  }

  resetLed(counting) {
    this.timer = this.countdown
    let intervalId = setInterval(() => {
      if (this.counter !== this.timer) {
        this.counter = this.countdown;
        clearInterval(intervalId)
      }
      else {
        this.timer = this.timer - 1;
        this.counter = this.timer;
        this.timeoutSentence = `Turning all leds of again in ${this.timer} seconds`
        if (this.timer === 0) {
          this.counter = this.countdown
          this.timeoutSentence = ''
          clearInterval(intervalId)
        }
      }
    }, 1000)  
  }
}

 

