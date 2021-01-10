import { NgxSpinnerService } from 'ngx-spinner';
import { Email } from './../../classes/email';
import { StudentServiceService } from './../../services/student-service.service';
import { Etudiant } from './../../classes/etudiant';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from './../../classes/user';
import { RegistrationService } from './../../services/registration.service';
import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';

@Component({
  selector: 'app-view-details-student',
  templateUrl: './view-details-student.component.html',
  styleUrls: ['./view-details-student.component.scss']
})
export class ViewDetailsStudentComponent implements OnInit {

  nowUser: User = new User();
  user: User = new User();
  student: Etudiant = new Etudiant();
  matricule: string;
  spinner: number;
  email: Email = new Email();

  constructor(private _service: RegistrationService, private route: Router, private _serviceStudent: StudentServiceService, private _ativatedRoute: ActivatedRoute, private _spinnerService: NgxSpinnerService, private router: Router) { 

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
    this.getStudentNow();
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

  getStudentNow() {
    this.matricule  = this._ativatedRoute.snapshot.paramMap.get('matricule'); 
    this._serviceStudent.getStudent(this.matricule).subscribe(
      data => {
        this.student = data;
      }
    );
  }

  sendEmailValidated() {
    this.spinner = 0;
    this._spinnerService.show();
    this.email.to = this.student.email;
    this.email.body = "Vos informations ont été validé et votre compte a été activé Cordialement IME Message envoyé automatiquement veuillez ne pas répondre";
    this.email.topic = "Création de compte dans la plate forme de IME";
    console.log(this.student.email);
    this._serviceStudent.postEmail(this.email).subscribe(
      data => {
        console.log(data);
      }
    );
    this._serviceStudent.saveStudentAfterValidation(this.student.matricule).subscribe(
      data => {
        setTimeout(
          () => {
            console.log(data);
             this._spinnerService.hide()
             this.router.navigate(['/menu'])
          }, 5000
       );
      }
    );
  }

  sendEmailReject() {
    this.email.to = this.student.email;
    this.email.body = "Vos informations ont été réjecter et votre compte n'a pas été activé. Enregistrer des informations correctes. Cordialement IME. Message envoyé automatiquement veuillez ne pas répondre";
    this.email.topic = "Création de compte dans la plate forme de IME";
    console.log(this.student.email);
    this._serviceStudent.postEmail(this.email).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['/student'])
      }
    )
  }

}
