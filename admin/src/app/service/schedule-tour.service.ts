import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tour } from '../view-slots/Tour';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ScheduleTourService {
  private apiUrl = 'http://localhost:8084/tour/';
  constructor(private http: HttpClient) { }

  getAllTours():Observable<Tour[]>{
    const url = `${this.apiUrl}getAllTour`;
    console.log("url: "+url);
    return this.http.get<any>(url);
  }
}
