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


  ToggleRedLed1() {
    console.log("toggle red led 1")
    this.appService.ServiceToggleRedLed1()
  }

  TurnOnRedLed1() {
    console.log("toggle red led 2")
    this.appService.ServiceToggleRedLed1()
  }
}
 

