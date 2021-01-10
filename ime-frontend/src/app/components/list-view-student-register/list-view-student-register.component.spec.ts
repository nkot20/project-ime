import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListViewStudentRegisterComponent } from './list-view-student-register.component';

describe('ListViewStudentRegisterComponent', () => {
  let component: ListViewStudentRegisterComponent;
  let fixture: ComponentFixture<ListViewStudentRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListViewStudentRegisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListViewStudentRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
