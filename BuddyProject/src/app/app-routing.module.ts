import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentComponent } from './appointment/appointment.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ServiceComponent } from './service/service.component';
import { DepartmentComponent } from './department/department.component';
import { DoctorsComponent } from './doctors/doctors.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AdminComponent } from './admin/admin.component';
// import { canactivateGuard } from './ap.guard';
import { AuthGuard } from './ap.guard';

const routes: Routes = [
  { path:"", redirectTo:'home', pathMatch: 'full' },
  {path:'appointment', component:AppointmentComponent},
  {path:'about', component:AboutComponent},
  {path:'service', component:ServiceComponent},
  {path:'department', component:DepartmentComponent},
  {path:'doctors', component:DoctorsComponent},
  {path:'contact', component:ContactComponent},
  {path:'home', component:HomeComponent},
  {path:'login', component:LoginComponent},
  {path: 'sign-up', component:SignUpComponent},
  {path:'admin' , canActivate: [AuthGuard], component:AdminComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
