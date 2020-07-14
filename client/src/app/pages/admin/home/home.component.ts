import { Component, OnInit } from '@angular/core';
import { DoctorService } from 'app/services/doctor.service';
import { InpatientService } from 'app/services/inpatient.service';
import { Inpatient } from 'app/models/Inpatient';
import { Doctor } from 'app/models/Doctor';
import { SickNoteService } from 'app/services/sicknote.service';
import { SickNote } from 'app/models/SickNote';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit {
  
  doctors: Array<Doctor> = [];
  inpatients: Array<Inpatient> = [];
  sickNotes: Array<SickNote> = [];

  constructor(
    private doctorService: DoctorService, 
    private inpatientService: InpatientService,
    private sickNoteService: SickNoteService) { }

  ngOnInit() {
    this.doctorService.getAll().subscribe(result => {
      this.doctors = result;
      console.log(this.doctors)
    });
    this.inpatientService.getAll().subscribe(result => {
      this.inpatients = result;
      console.log(this.inpatients)
    });
    this.sickNoteService.getAll().subscribe(result => {
      this.sickNotes = result;
      console.log(this.sickNotes)
    });
  }

}
