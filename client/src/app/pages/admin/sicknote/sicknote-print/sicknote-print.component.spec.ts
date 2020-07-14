import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SickNotePrintComponent } from './sicknote-print.component';

describe('SicknotePrintComponent', () => {
  let component: SickNotePrintComponent;
  let fixture: ComponentFixture<SickNotePrintComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SickNotePrintComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SickNotePrintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
