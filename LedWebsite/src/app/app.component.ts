import { Component } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'LedWebsite';

  constructor(private appService: AppService) { }

  ToggleGreenLed0() {
    console.log("toggle Green led 0")
    this.appService.ServiceToggleGreenLed0().subscribe()
  }

  ToggleYellowLed0() {
    console.log("toggle Yellow led 0")
    this.appService.ServiceToggleYellowLed0().subscribe()
  }

  ToggleYellowLed1() {
    console.log("toggle Yellow led 1")
    this.appService.ServiceToggleYellowLed1().subscribe()
  }

  ToggleRedLed0() {
    console.log("toggle red led 0")
    this.appService.ServiceToggleRedLed0().subscribe()
  }

  ToggleRedLed1() {
    console.log("toggle red led 1")
    this.appService.ServiceToggleRedLed1().subscribe()
  }
}

 

