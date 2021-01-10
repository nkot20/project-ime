import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageAfterRegistrationComponent } from './message-after-registration.component';

describe('MessageAfterRegistrationComponent', () => {
  let component: MessageAfterRegistrationComponent;
  let fixture: ComponentFixture<MessageAfterRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessageAfterRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessageAfterRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
