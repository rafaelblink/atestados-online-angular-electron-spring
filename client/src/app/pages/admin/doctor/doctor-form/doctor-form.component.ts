import { Component, OnInit } from '@angular/core';
import { DoctorService } from 'app/services/doctor.service';
import Swal from 'sweetalert2';
import { Doctor } from 'app/models/Doctor';
import { Router, Route, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-doctor-form',
  templateUrl: './doctor-form.component.html',
  styleUrls: ['./doctor-form.component.sass']
})
export class DoctorFormComponent implements OnInit {
  public doctor: Doctor;
  public title: string;

  constructor(
    private doctorService: DoctorService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.doctor = new Doctor();
  }


  ngOnInit() {
    this.title = 'Cadastrar';
    this.activatedRoute.params.subscribe(params => {
      if (params.id) {
        this.title = 'Editar';
        this.doctorService.getById(params.id).subscribe(result => {
          this.doctor = result;
          console.log(this.doctor);
        });
      }
    });
  }

  onSubmit() {
    this.doctorService.createOrUpdate(this.doctor).subscribe(result => {
      let title = 'Cadastrado';
      if (this.doctor.id) { title = 'Editado' };
      Swal.fire({
        title: "Sucesso xD",
        text: `Médico ${title} com Sucesso!`,
        type: 'success'
      })
      this.router.navigate(["/admin/medicos"]);
      this.doctor = new Doctor();
    }, err => {
      console.log(err);
    });
  }

}
