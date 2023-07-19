import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent {
  AdminForm:FormGroup;
  constructor(private fb:FormBuilder, private router:Router){
    this.AdminForm =  fb.group({
      username:['',Validators.compose([Validators.required])],
      password:['',Validators.compose([Validators.required])],
    });
  }

  routeToLogin(){
    this.router.navigate(['/view-catalogue']);
  }
}
