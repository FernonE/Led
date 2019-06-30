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


  TurnOnRedLed1() {
    console.log("I want to turn on my red led 1")
    this.appService.ServiceTurnOnRedLed1()
  }
}
 

