import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { Doctor } from 'app/models/Doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) { }

  createOrUpdate(doctor: Doctor) {
    return this.http.post(environment.apiUrl+'/admin/doctor', doctor);
  }

  getAll(){
    return this.http.get<Array<Doctor>>(environment.apiUrl+'/admin/doctor');
  }

  remove(id: Number) {
    return this.http.delete(environment.apiUrl+'/admin/doctor/'+id);
  }

  getById(id: Number) {
    return this.http.get<Doctor>(environment.apiUrl+'/admin/doctor/'+id);
  }
}
