import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

@Injectable()
export class AppService {

  constructor(private http: HttpClient) { }

  GetGreenLed0() : Observable<boolean>{
    return this.http.get<boolean>("/led/greenLed0")
  }

  GetYellowLed0(): Observable<boolean> {
    return this.http.get<boolean>("/led/yellowLed0")
  }

  GetYellowLed1(): Observable<boolean> {
    return this.http.get<boolean>("/led/yellowLed1")
  }

  GetRedLed0(): Observable<boolean> {
    return this.http.get<boolean>("/led/RedLed0")
  }

  GetRedLed1(): Observable<boolean> {
    return this.http.get<boolean>("/led/RedLed1")
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

  ServiceTurnOffAll() {
    console.log("turning off all leds")
    return this.http.get("/led/AllOff")
  }


}
