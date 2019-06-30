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


  ToggleRedLed0() {
    console.log("toggle red led 0")
    this.appService.ServiceToggleRedLed0()
  }

  ToggleRedLed1() {
    console.log("toggle red led 1")
    this.appService.ServiceToggleRedLed1()
  }
}

 

