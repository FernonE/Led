import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  TurnOnRedLed1() {
    return this.http.get("http://192.168.178.37:4200/led/redLed1/On")
  }
}
