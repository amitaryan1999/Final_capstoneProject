import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Featured } from '../featured-property/featured';

@Injectable({
  providedIn: 'root'
})
export class FeaturedPService {

  private apiUrl = 'http://localhost:8086/featured/getAllFeatured';

  constructor(private http: HttpClient) { }


  getAllFeaturedProperty():Observable<Featured[]>{

    const url = `${this.apiUrl}`;

    console.log("url: "+url);

    return this.http.get<any>(url);

  }

}
