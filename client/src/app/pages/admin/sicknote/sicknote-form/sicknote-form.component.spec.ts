import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SickNoteFormComponent } from './sicknote-form.component';

describe('SicknoteFormComponent', () => {
  let component: SickNoteFormComponent;
  let fixture: ComponentFixture<SickNoteFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SickNoteFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SickNoteFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
