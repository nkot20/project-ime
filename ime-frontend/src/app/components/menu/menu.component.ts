import { NgxSpinnerService } from 'ngx-spinner';
import { Router } from '@angular/router';
import { User } from './../../classes/user';
import { RegistrationService } from './../../services/registration.service';
import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  nowUser: User = new User();
  user: User = new User();

  constructor(private _service: RegistrationService, private route: Router) { 

    $(document).ready(function () {
      var trigger = $('.hamburger'),
          overlay = $('.overlay'),
         isClosed = false;
    
        trigger.click(function () {
          hamburger_cross();      
        });
    
        function hamburger_cross() {
    
          if (isClosed == true) {          
            overlay.hide();
            trigger.removeClass('is-open');
            trigger.addClass('is-closed');
            isClosed = false;
          } else {   
            overlay.show();
            trigger.removeClass('is-closed');
            trigger.addClass('is-open');
            isClosed = true;
          }
      }
      
      $('[data-toggle="offcanvas"]').click(function () {
            $('#wrapper').toggleClass('toggled');
      });  
    });

  }

  ngOnInit(): void {
    this.searchNowUser();
  }

  searchNowUser() {
    let nameUser = sessionStorage.getItem('userName');
    this.user.iduser = nameUser;
    this._service.searchUser(this.user).subscribe(
      data => {
        this.nowUser = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  logOut() {
    sessionStorage.removeItem('userName');
    this.route.navigate(['']);
  }

}
