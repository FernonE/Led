import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  ServiceToggleRedLed0() {
    console.log("redled0 service")
    return this.http.get("http://192.168.178.37:9001/led/redLed0/toggle")
  }

  ServiceToggleRedLed1() {
    console.log("redled1 service")
    return this.http.get("/led/redLed0/toggle")
  }


}
