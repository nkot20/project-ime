import { User } from './../classes/user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private baseUrl = "http://localhost:8080/api/v1";
  user_menu: User = new User();
  user: User = new User();

  constructor(private _http: HttpClient) { }

  loginUser(user :User): Observable<any> {
    console.log(user);
    const searchUrl = `${this.baseUrl}/login/`;
    return this._http.post<any>(searchUrl,user);
  }

  searchUser(user: User): Observable<any> {
    const searchUrl = `${this.baseUrl}/searchUser/`;
    return this._http.post<any>(searchUrl,user);
  }

  isUserLoggedIn() {
    let userIs = sessionStorage.getItem('userName');
    console.log(!(userIs === null))
    return (userIs === null)
  }

}
