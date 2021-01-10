import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-message-after-registration',
  templateUrl: './message-after-registration.component.html',
  styleUrls: ['./message-after-registration.component.scss']
})
export class MessageAfterRegistrationComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit(): void {
  }

  retour() {
    this.router.navigate(['']);
  }

}
