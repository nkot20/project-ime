import { Etudiant } from './../classes/etudiant';
import { Filiere } from './../classes/filiere';
import { Niveau } from './../classes/niveau';
import { User } from './../classes/user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

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

  GetNiveau(): Observable<Niveau[]> {
    const searchUrl = `${this.baseUrl}/niveaus`;
    return this._http.get<GetResponseNiveau>(searchUrl).pipe(
      map(response => response._embedded.niveaus)
    );
  }

  GetFiliere(): Observable<Filiere[]> {
    const searchUrl = `${this.baseUrl}/filieres`;
    return this._http.get<GetResponseFiliere>(searchUrl).pipe(
      map(response => response._embedded.filieres)
    );
  }

  saveStudent(etudiant: Etudiant): Observable<any> {
    const postStudent = `${this.baseUrl}/savestudent/`;
    return this._http.post<any>(postStudent, etudiant);
  }

  getStudent(): Observable<Etudiant[]> {
    const getStudent = `${this.baseUrl}/studentregister`;
    return this._http.get<Etudiant[]>(getStudent);
  }

}

interface GetResponseNiveau {

  _embedded: {
    niveaus: Niveau[];
  };

}

interface GetResponseFiliere {

  _embedded: {
    filieres: Filiere[];
  };

}
