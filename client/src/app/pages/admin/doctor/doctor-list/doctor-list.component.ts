import { Component, OnInit } from '@angular/core';
import { DoctorService } from 'app/services/doctor.service';
import { Doctor } from 'app/models/Doctor';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-doctor-list',
  templateUrl: './doctor-list.component.html',
  styleUrls: ['./doctor-list.component.sass']
})
export class DoctorListComponent implements OnInit {

  constructor(private doctorService: DoctorService) { }

  doctors: Array<Doctor>;

  ngOnInit() {
    this.doctorService.getAll().subscribe(result => {
      this.doctors = result;
      console.log(this.doctors);
    }, err => {
      console.log(err);
    });
  }

  remove(doctor: Doctor) {
    Swal.fire({
      title: 'Confirmação',
      text: 'Você deseja realmente remover este médico?',
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#d343a40',
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.value) {
        this.doctorService.remove(doctor.id).subscribe(resultRemove => {
          Swal.fire(
            'Removido!',
            'Médico removido com sucesso! Vamos sentir falta dele :(',
            'success'
          );
          this.doctorService.getAll().subscribe(resultAll => {
            this.doctors = resultAll;
          }, err => {
            console.log(err);
          });
        }, error => {
          Swal.fire(
            'Error!',
            error.message,
            'error'
          );
        });
      }
    });
  }

}
