import { Observable } from 'rxjs';
import { Email } from './../classes/email';
import { Etudiant } from './../classes/etudiant';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  private baseUrl = "http://localhost:8080/api/v1"; 

  constructor(private _http: HttpClient) { }

  getStudent(matricule: string) {
    const url = `${this.baseUrl}/student/${matricule}`;
    return this._http.get<Etudiant>(url);
  }

  postEmail(email: Email): Observable<any> {
    const url = `${this.baseUrl}/sendemail`;
    return this._http.post<any>(url, email);
  }

  saveStudentAfterValidation(matricule: string): Observable<any> {
    const url = `${this.baseUrl}/studentupdate/${matricule}`;
    return this._http.put<any>(url, matricule);
  } 

}
