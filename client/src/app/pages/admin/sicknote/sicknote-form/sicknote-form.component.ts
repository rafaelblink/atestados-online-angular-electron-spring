import {
  Component,
  OnInit
} from '@angular/core';
import {
  Doctor
} from 'app/models/Doctor';
import {
  Inpatient
} from 'app/models/Inpatient';
import {
  DoctorService
} from 'app/services/doctor.service';
import {
  InpatientService
} from 'app/services/inpatient.service';
import {
  SickNote
} from 'app/models/SickNote';
import {
  SickNoteService
} from 'app/services/sicknote.service';
import Swal from 'sweetalert2';
import {
  Router, ActivatedRoute
} from '@angular/router';

@Component({
  selector: 'app-sicknote-form',
  templateUrl: './sicknote-form.component.html',
  styleUrls: ['./sicknote-form.component.sass']
})
export class SickNoteFormComponent implements OnInit {

  doctors: Array < Doctor > = [];
  doctorSelected: Doctor;

  inpatients: Array < Inpatient > = [];
  inpatientSelected: Inpatient;

  sickNote: SickNote = new SickNote();

  title = 'Cadastrar';
  constructor(
    private router: Router,
    private doctorService: DoctorService,
    private inpatientService: InpatientService,
    private sickNoteService: SickNoteService,
    private activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      if (params.id) {
        this.title = 'Editar';
        this.sickNoteService.getById(params.id).subscribe(result => {
          this.sickNote = result;

          this.doctorService.getById(this.sickNote.doctor.id).subscribe(resultDoctor => {
            this.doctorSelected = resultDoctor;
          });

          this.inpatientService.getById(this.sickNote.inpatient.id).subscribe(resultInpatient => {
            this.inpatientSelected = resultInpatient;
          });
        });
      }
    });
    this.doctorService.getAll().subscribe(result => {
      this.doctors = result;
      console.log(this.doctors);
    });
    this.inpatientService.getAll().subscribe(result => {
      this.inpatients = result;
      console.log(this.inpatients);
    });
  }

  onSubmit() {
    this.sickNote.doctor = this.doctorSelected;
    this.sickNote.inpatient = this.inpatientSelected;
    this.sickNoteService.createOrUpdate(this.sickNote).subscribe(result => {
      console.log(result);
      let title = 'Cadastrado';
      if(this.sickNote.id) {
        title = 'Editado';
      }
      Swal.fire({
        title: 'Sucesso xD',
        text: `Atestado ${title} com Sucesso!`,
        type: 'success'
      });
      this.router.navigate(['/admin/atestados']);
    });
  }

}
