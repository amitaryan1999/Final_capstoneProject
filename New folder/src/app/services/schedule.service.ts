import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  private baseurl:string="http://localhost:8087/schtour/addTour"
  
  private dataSubject = new BehaviorSubject<string>('');
  constructor(private http:HttpClient) { }

  setData(data: string) {
    this.dataSubject.next(data);
  }

  getData() {
    return this.dataSubject.asObservable();
  }

 addTourdata(sdata:any)

 {  
  sdata.property_id = this.getData();

  return this.http.post(`${this.baseurl}`,sdata)

 }
}
