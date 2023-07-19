import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginForm!: FormGroup
  isLoggedIn:boolean = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  passwordVisible: boolean = false;
  r:boolean=false
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }
  emailRegex = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/

  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.maxLength(32), Validators.pattern(this.emailRegex)]],
      password: ['', [Validators.required, Validators.maxLength(32), Validators.minLength(8)]],
    })
  }
  getControl(name: any): AbstractControl | null {

    return this.loginForm.get(name)

  }
  togglePasswordVisibility() {
    this.passwordVisible = !this.passwordVisible;
  }
  // login() {
  //  console.log("userdata ",this.loginForm.value)
  //   this.http.post<any>("http://localhost:8083/path/login",this.loginForm.value)
  //     .subscribe(res => {
  //       const r=res
  //       if(res) {
  //         this.isLoggedIn = true;
  //         this.isLoginFailed = false;
  //         console.log("login successful", res, this.isLoggedIn);
  //       }
  //       else {
  //         this.isLoggedIn = false;
  //         this.isLoginFailed = true;
  //         console.log("login failed", res, this.isLoggedIn);
  //       }
  //     },
  //       err=>{
  //         console.log(err)
  //       }
  //       // const user = res.find((a: any) => {
  //       //   return a.email === this.loginForm.value.email && a.password === this.loginForm.value.password
  //       );
  //       // console.log(this.r);
  //     //   console.log(user);
  //     //   if (user) {
  //     //     // alert("login success...");
  //     //     this.isLoggedIn = true;
  //     //     this.isLoginFailed = false;
        
  //     //     this.loginForm.reset();
  //     //     this.router.navigate(['dashboard'])
  //     //   }else{
  //     //     this.isLoggedIn = false;
  //     //     this.isLoginFailed = true;
  //     //   }
  //     //   //  else {
  //     //   //   // alert("user not found...")
  //     //   // }
  //     // }, err => {
  //     //   // alert("something went wrong....")
  //     //   this.errorMessage = err.error.message;
  //     //   this.isLoginFailed = true;
  //     // })
  // }




  login() {
    console.log("userdata ", this.loginForm.value);
    this.http.post<any>("http://localhost:8098/path/login", this.loginForm.value)
      .subscribe(
        (res) => {
          if (res) {
            this.isLoggedIn = true;
            this.isLoginFailed = false;
            console.log("login successful", res, this.isLoggedIn);
          } else {
            this.isLoggedIn = false;
            this.isLoginFailed = true;
            console.log("login failed", res, this.isLoggedIn);
          }
        },
        (err) => {
          console.log(err);
          this.isLoggedIn = false;
          this.isLoginFailed = true;
          this.errorMessage = err.error.message;
        }
      );
  }
  

}
