import { Component, OnInit } from '@angular/core';
import { SickNoteService } from 'app/services/sicknote.service';
import { SickNote } from 'app/models/SickNote';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-sicknote-print',
  templateUrl: './sicknote-print.component.html',
  styleUrls: ['./sicknote-print.component.sass']
})
export class SickNotePrintComponent implements OnInit {

  sickNote: SickNote = new SickNote();
  dateNow: Date = new Date();
  constructor(private sickNoteService: SickNoteService, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      if (params.id) {
        this.sickNoteService.getById(params.id).subscribe(result => {
          this.sickNote = result;
        }, erro => {
          console.log(erro);
        }, () => {
          setTimeout(() => {
            window.print();
            window.close();
          }, 500);
        });
      }
    });
    // window.close();
  }

}
