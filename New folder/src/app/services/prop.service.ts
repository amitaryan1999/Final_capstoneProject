import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { FormGroup } from '@angular/forms';
import { Property } from '../property/property';

@Injectable({
  providedIn: 'root'
})
export class PropService {

  private apiUrl = 'http://localhost:8085/admin/';

  constructor(private http: HttpClient) { }




  getAllProperties():Observable<Property[]>{

    const url = `${this.apiUrl}getAllProperty`;

    console.log("url: "+url);

    return this.http.get<any>(url);

  }




  getPropertyById(aId:string|null):Observable<any[]>{

    const url = `${this.apiUrl}getPropertybyid/${aId}`;

    console.log("url: "+url);

    return this.http.get<any>(url);

  }




  addProperty(myForm:FormData):Observable<any[]>{

    console.log(myForm);

    const url = `${this.apiUrl}addProperty`;

    return this.http.post<any[]>(url, myForm);

  }




  UpdateProperty(myForm:FormGroup, agentID:String):Observable<any[]>{

    const url = `${this.apiUrl}updateProperty/${agentID}`;

    console.log("url: "+url);

    return this.http.put<any[]>(url, myForm);

  }




  deleteProperty(agentID:String):Observable<any[]>{

    const url = `${this.apiUrl}delPropertybyid/${agentID}`;

    console.log("url: "+url);

    return this.http.delete<any[]>(url);

  }
}
