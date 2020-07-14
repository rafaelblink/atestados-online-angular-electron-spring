import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'app/models/User';

import * as moment from "moment";
import { environment } from 'environments/environment';




@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  constructor(private http: HttpClient) { }

  login(email:string, password:string ) {
    return this.http.post<User>(environment.apiUrl + '/auth/signIn', {email, password});
  }
  public setSession(authResult) {
    localStorage.setItem('accessToken', authResult.accessToken);

  }
  public isLogged() {
    return localStorage.getItem('accessToken');
  }
  public logout() {
    localStorage.removeItem('accessToken');
  }
  // public isLoggedIn() {
  //   return moment().isBefore(this.getExpiration());
  // }
  // isLoggedOut() {
  //   return !this.isLoggedIn();
  // }
  // getExpiration() {
  //     const expiration = localStorage.getItem("expires_at");
  //     const expiresAt = JSON.parse(expiration);
  //     return moment(expiresAt);
  // }     
}
