import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public signupForm!: FormGroup;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }
  integreRegex = /^\d+$/
  emailRegex = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/

  ngOnInit(): void {
    // throw new Error('Method not implemented.');

    this.signupForm = this.formBuilder.group({
      firstName: ['', [Validators.required, Validators.maxLength(12)]],
      lastName: ['', [Validators.required, Validators.maxLength(12)]],
      mobile: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10), Validators.pattern(this.integreRegex)]],
      email: ['', [Validators.required, Validators.maxLength(32), Validators.pattern(this.emailRegex)]],
      address: ['', [Validators.required, Validators.maxLength(32)]],
      password: ['', [Validators.required, Validators.maxLength(32), Validators.minLength(8)]],

    })

  }
  getControl(name: any): AbstractControl | null {

    return this.signupForm.get(name)

  }
  signup() {
    console.log(this.signupForm.value)
    this.http.post<any>("http://localhost:8082/register/register", this.signupForm.value)
      .subscribe(res => {
        // console.log(res);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.signupForm.reset();
        this.router.navigate(['login']);
      }, err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
        this.isSuccessful = false;
      });
  }
  

}
