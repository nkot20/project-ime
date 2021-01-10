import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDetailsStudentComponent } from './view-details-student.component';

describe('ViewDetailsStudentComponent', () => {
  let component: ViewDetailsStudentComponent;
  let fixture: ComponentFixture<ViewDetailsStudentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewDetailsStudentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDetailsStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
