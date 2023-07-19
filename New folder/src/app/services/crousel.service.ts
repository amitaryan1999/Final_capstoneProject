import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Crousel } from '../crousel/Crousel';

@Injectable({
  providedIn: 'root'
})
export class CrouselService {

  private apiUrl = 'http://localhost:8088/carousel/photos/getAllID';

  constructor(private http: HttpClient) { }


  getPropertyID():Observable<Crousel[]>{

    const url = `${this.apiUrl}`;

    console.log("url: "+url);

    return this.http.get<any>(url);

  }
}
