import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { SickNote } from 'app/models/SickNote';

@Injectable({
  providedIn: 'root'
})
export class SickNoteService {

  constructor(private http: HttpClient) { }

  createOrUpdate(sicknote: SickNote) {
    return this.http.post(environment.apiUrl+'/admin/sicknotes', sicknote);
  }

  getAll(){
    return this.http.get<Array<SickNote>>(environment.apiUrl+'/admin/sicknotes');
  }

  remove(id: Number) {
    return this.http.delete(environment.apiUrl+'/admin/sicknotes/'+id);
  }

  getById(id: Number) {
    return this.http.get<SickNote>(environment.apiUrl+'/admin/sicknotes/'+id);
  }
}
