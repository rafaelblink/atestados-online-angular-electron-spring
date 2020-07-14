import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';

import { Inpatient } from 'app/models/Inpatient';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InpatientService {

  constructor(private http: HttpClient) { }

  createOrUpdate(inpatient: Inpatient) {
    return this.http.post(environment.apiUrl+'/admin/inpatient', inpatient);
  }

  getAll(){
    return this.http.get<Array<Inpatient>>(environment.apiUrl+'/admin/inpatient');
  }

  remove(id: Number) {
    return this.http.delete(environment.apiUrl+'/admin/inpatient/'+id);
  }

  getById(id: Number) {
    return this.http.get<Inpatient>(environment.apiUrl+'/admin/inpatient/'+id);
  }
}
