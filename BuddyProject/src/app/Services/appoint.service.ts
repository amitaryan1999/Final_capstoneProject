import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppointService {

  private baseurl:string="http://localhost:8084/appoint/"

  constructor(private http:HttpClient) { }

 addAppointdata(sdata:any)

 {

  return this.http.post(`${this.baseurl}addAppoint`,sdata)

}
getAllAppoint(){
  return this.http.get(`${this.baseurl}getAllAppoint`)
}
}
