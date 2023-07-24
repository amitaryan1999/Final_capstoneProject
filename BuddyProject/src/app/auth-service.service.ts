import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { Login } from './login/login';

@Injectable()
export class AuthServiceService {

  private authUrl:string;

  constructor(private httpClient:HttpClient) {
  this.authUrl = "http://localhost:8087/api/login";
  }
 setBearerToken(token:string) {
 
  localStorage.setItem('bearerToken',token);
 
 }
  getBearerToken() {
 
  return localStorage.getItem('bearerToken');
  }
  isUserAuthenticated(token: any):Observable<boolean>{
    console.log("is called"+ token)
    // let status:boolean = false;
    return this.httpClient.post(`${this.authUrl}/isAuthenticated`,{},{
      headers: new HttpHeaders().set('Authorization',`Bearer ${token}`)
    }).pipe(
      map(response => {
        // Check the response data and return a boolean based on your criteria
        if (response === true) {
          return true;
        } else {
          return false;
        }}), // Assuming a successful response means the user is authenticated
      catchError(() => of(false)) // Assuming an error response means the user is not authenticated
    );
  
  }
}
