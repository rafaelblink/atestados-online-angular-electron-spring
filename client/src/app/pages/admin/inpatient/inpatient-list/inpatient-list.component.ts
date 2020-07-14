import { Component, OnInit } from '@angular/core';
import { InpatientService } from 'app/services/inpatient.service';
import { Inpatient } from 'app/models/Inpatient';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-inpatient-list',
  templateUrl: './inpatient-list.component.html',
  styleUrls: ['./inpatient-list.component.sass']
})
export class InpatientListComponent implements OnInit {

  constructor(private inpatientService: InpatientService) { }

  inpatients: Array<Inpatient>;

  ngOnInit() {
    this.inpatientService.getAll().subscribe(result => {
      this.inpatients = result;
      console.log(this.inpatients);
    }, err => {
      console.log(err);
    })
  }

  remove(inpatient: Inpatient) {
    Swal.fire({
      title: 'Confirmação',
      text: "Você deseja realmente remover este médico?",
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#d343a40',
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.value) {
        this.inpatientService.remove(inpatient.id).subscribe(resultRemove => {
          this.inpatientService.getAll().subscribe(result => {
            this.inpatients = result;
            Swal.fire(
              'Removido!',
              'Paciente removido com sucesso! Vamos sentir falta dele :(',
              'success'
            );
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
