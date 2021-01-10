import { NgxSpinnerService } from 'ngx-spinner';
import { Etudiant } from './../../classes/etudiant';
import { RegistrationService } from './../../services/registration.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-view-student-register',
  templateUrl: './list-view-student-register.component.html',
  styleUrls: ['./list-view-student-register.component.scss']
})
export class ListViewStudentRegisterComponent implements OnInit {

  searchTerm: string;
  page = 1;
  pageSize = 4;
  collectionSize: number;
  currentRate = 8;
  studentsNoValidate: Etudiant[];
  AllstudentsNoValidate: Etudiant[];

  constructor(private _service: RegistrationService, private _spinnerService: NgxSpinnerService) { }

  ngOnInit(): void {
    this.getStudentNoValidaate();
    //this.search();
  }

  getStudentNoValidaate() {
    this._spinnerService.show();
    
    this._service.getStudent().subscribe(
      data => {
        console.log(data);
        this.collectionSize = data.length;
        this.studentsNoValidate = data;
        this.AllstudentsNoValidate = this.studentsNoValidate
      }
    );
  }

  search(value: string): void {
    this.studentsNoValidate = this.AllstudentsNoValidate.filter(
        (val) => val.matricule.toLowerCase().includes(value)
    );
    this.collectionSize = this.studentsNoValidate.length;
  }

}
