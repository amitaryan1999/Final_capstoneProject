import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsultantService {

  private apiUrl = 'http://localhost:8089/consult/addConsult';

  constructor(private http: HttpClient) { }


  addTourdata(myForm:FormData):Observable<any>{

    console.log(myForm);

    const url = `${this.apiUrl}`;

    return this.http.post<any>(url, myForm);


}
}
