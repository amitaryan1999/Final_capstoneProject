import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Agent } from '../Agent';
@Injectable({
  providedIn: 'root'
})
export class AgentService {
  private apiUrl = 'http://localhost:8082/api/agent/';
  constructor(private http: HttpClient) { }

  getAgentById(aId:String):Observable<Agent[]>{
    console.log(aId);
    const url = `${this.apiUrl}getAgentById/${aId}`;
    console.log("url: "+url);
    return this.http.get<any>(url);
  }
}
