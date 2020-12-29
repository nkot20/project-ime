import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { RegistrationService } from './registration.service';

@Injectable({
  providedIn: 'root'
})
export class AuthguardService {

  constructor(private _service: RegistrationService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if(this.isUserLoggedIn()) {
      return true;
    }
    else {
      this.router.navigate(['']);
      return false;
    }
  }

  isUserLoggedIn() {
    let userIs = sessionStorage.getItem('userName');
    console.log(!(userIs === null))
    console.log(userIs)
    return !(userIs === null)
  }

}
