import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule }   from '@angular/forms';
import { HomeComponent } from './pages/admin/home/home.component';
import { HeaderComponent } from './pages/admin/shared/header/header.component';
import { DoctorFormComponent } from './pages/admin/doctor/doctor-form/doctor-form.component';
import { DoctorListComponent } from './pages/admin/doctor/doctor-list/doctor-list.component';
import { AuthInterceptor } from './interceptors/authInterceptor.service';
import { InpatientListComponent } from './pages/admin/inpatient/inpatient-list/inpatient-list.component';
import { InpatientFormComponent } from './pages/admin/inpatient/inpatient-form/inpatient-form.component';
import { SickNoteListComponent } from './pages/admin/sicknote/sicknote-list/sicknote-list.component';
import { SickNoteFormComponent } from './pages/admin/sicknote/sicknote-form/sicknote-form.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { NgxMaskModule } from 'ngx-mask';
import { SickNotePrintComponent } from './pages/admin/sicknote/sicknote-print/sicknote-print.component';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment'


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    HomeComponent,
    HeaderComponent,
    DoctorListComponent,
    DoctorFormComponent,
    DoctorListComponent,
    InpatientListComponent,
    InpatientFormComponent,
    SickNoteListComponent,
    SickNoteFormComponent,
    SickNotePrintComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgSelectModule,
    NgxMaskModule.forRoot(),
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
