import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  ServiceTurnOnRedLed1() {
    console.log("now i'm in the service for turning it on")
    return this.http.get("http://192.168.178.37.4200")
  }
}
