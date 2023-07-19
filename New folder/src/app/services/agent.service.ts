import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Agent } from '../agent/agent';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgentService {

  private apiUrl = 'http://localhost:8084/agent/';

  constructor(private http: HttpClient) { }


  getAllAgents():Observable<Agent[]>{

    const url = `${this.apiUrl}getAllAgents`;

    console.log("url: "+url);

    return this.http.get<any>(url);

  }


  getAgentByID(aName:string|null):Observable<Agent[]>{
    const url = `${this.apiUrl}getAgentById/${aName}`;

    console.log("url: "+url);

    return this.http.get<any>(url);

  }
}
