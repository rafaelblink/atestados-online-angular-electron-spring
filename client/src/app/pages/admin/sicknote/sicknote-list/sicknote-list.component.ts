import { Component, OnInit } from '@angular/core';
import { SickNote } from 'app/models/SickNote';
import { SickNoteService } from 'app/services/sicknote.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sicknote-list',
  templateUrl: './sicknote-list.component.html',
  styleUrls: ['./sicknote-list.component.sass']
})
export class SickNoteListComponent implements OnInit {
  sicknotes: Array<SickNote>;
  constructor(private sickNoteService: SickNoteService, private router: Router) { }

  ngOnInit() {
    this.sickNoteService.getAll().subscribe(result => {
      this.sicknotes = result;
      console.log(this.sicknotes);
    }, err => {
      console.log(err);
    });
  }

  remove(sickNote: SickNote) {
    Swal.fire({
      title: 'Confirmação',
      text: 'Você deseja realmente remover este atestado?',
      type: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#d33',
      cancelButtonColor: '#d343a40',
      confirmButtonText: 'Sim',
      cancelButtonText: 'Não'
    }).then((result) => {
      if (result.value) {
        this.sickNoteService.remove(sickNote.id).subscribe(resultRemove => {
          Swal.fire(
            'Removido!',
            'Atestado removido com sucesso! Vamos sentir falta dele :(',
            'success'
          );
          this.sickNoteService.getAll().subscribe(resultAll => {
            this.sicknotes = resultAll;
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
