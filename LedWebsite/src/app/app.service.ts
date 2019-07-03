import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  GetGreenLed0() {
    console.log("Getting green led status")
    return this.http.get("/led/greenLed0")
  }

  ServiceToggleGreenLed0() {
    console.log("greenled0 service")
    return this.http.get("/led/greenLed0/toggle")
  }



  ServiceToggleYellowLed0() {
    console.log("yellowled0 service")
    return this.http.get("/led/yellowLed0/toggle")
  }

  ServiceToggleYellowLed1() {
    console.log("yellowled1 service")
    return this.http.get("/led/yellowLed1/toggle")
  }

  ServiceToggleRedLed0() {
    console.log("redled0 service")
    return this.http.get("/led/redLed0/toggle")
  }

  ServiceToggleRedLed1() {
    console.log("redled1 service")
    return this.http.get("/led/redLed1/toggle")
  }


}
