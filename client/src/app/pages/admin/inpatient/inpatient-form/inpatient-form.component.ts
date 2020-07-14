import { Component, OnInit } from '@angular/core';
import { Inpatient } from 'app/models/Inpatient';
import { InpatientService } from 'app/services/inpatient.service';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-inpatient-form',
  templateUrl: './inpatient-form.component.html',
  styleUrls: ['./inpatient-form.component.sass']
})
export class InpatientFormComponent implements OnInit {
  public inpatient: Inpatient;
  public title: string;
  constructor(
    private inpatientService: InpatientService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.inpatient = new Inpatient();
  }

  ngOnInit() {
    this.title = 'Cadastrar';
    this.activatedRoute.params.subscribe(params => {
      if(params.id) {
        this.title = 'Editar';
        this.inpatientService.getById(params.id).subscribe(result => {
          this.inpatient = result;
          console.log(this.inpatient);
        })
      }
    });
  }

  onSubmit() {
    this.inpatientService.createOrUpdate(this.inpatient).subscribe(result => {
      let title = 'Cadastrado';
      if (this.inpatient.id) { title = 'Editado'; }
      Swal.fire({
        title: 'Sucesso xD',
        text: `Paciente ${title} com Sucesso!`,
        type: 'success'
      });
      this.router.navigate(['/admin/pacientes']);
      this.inpatient = new Inpatient();
    }, err => {
      console.log(err);
    });
  }

}
