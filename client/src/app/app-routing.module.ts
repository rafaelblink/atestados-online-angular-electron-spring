import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { HomeComponent } from './pages/admin/home/home.component';
import { DoctorListComponent } from './pages/admin/doctor/doctor-list/doctor-list.component';
import { DoctorFormComponent } from './pages/admin/doctor/doctor-form/doctor-form.component';
import { InpatientListComponent } from './pages/admin/inpatient/inpatient-list/inpatient-list.component';
import { InpatientFormComponent } from './pages/admin/inpatient/inpatient-form/inpatient-form.component';
import { SickNoteListComponent } from './pages/admin/sicknote/sicknote-list/sicknote-list.component';
import { SickNoteFormComponent } from './pages/admin/sicknote/sicknote-form/sicknote-form.component';
import { SickNotePrintComponent } from './pages/admin/sicknote/sicknote-print/sicknote-print.component';

const routes: Routes = [
  { path: '', component: LoginPageComponent },
  { path: 'admin/home', component: HomeComponent },
  // MEDICOS
  { path: 'admin/medicos', component: DoctorListComponent },
  { path: 'admin/medicos/cadastrar', component: DoctorFormComponent },
  { path: 'admin/medicos/editar/:id', component: DoctorFormComponent },
  // PACIENTES
  { path: 'admin/pacientes', component: InpatientListComponent },
  { path: 'admin/pacientes/cadastrar', component: InpatientFormComponent },
  { path: 'admin/pacientes/editar/:id', component: InpatientFormComponent },
  // ATESTADOS
  { path: 'admin/atestados', component: SickNoteListComponent },
  { path: 'admin/atestados/cadastrar', component: SickNoteFormComponent },
  { path: 'admin/atestados/editar/:id', component: SickNoteFormComponent },
  { path: 'admin/atestados/imprimir/:id', component: SickNotePrintComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
