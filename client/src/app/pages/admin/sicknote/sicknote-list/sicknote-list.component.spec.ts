import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SickNoteListComponent } from './sicknote-list.component';

describe('SicknoteListComponent', () => {
  let component: SickNoteListComponent;
  let fixture: ComponentFixture<SickNoteListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SickNoteListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SickNoteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
