import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveRequestNoteComponent } from './save-request-note.component';

describe('SaveRequestNoteComponent', () => {
  let component: SaveRequestNoteComponent;
  let fixture: ComponentFixture<SaveRequestNoteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaveRequestNoteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveRequestNoteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
