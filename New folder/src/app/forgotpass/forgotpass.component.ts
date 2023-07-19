import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgotpass',
  templateUrl: './forgotpass.component.html',
  styleUrls: ['./forgotpass.component.css'],
})
export class ForgotpassComponent {
  public forgotForm!: FormGroup;
  public isEmailSent: boolean = false;
  public isEmailFailed: boolean = false;
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {}

  emailRegex =
    /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/;

  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    this.forgotForm = this.formBuilder.group({
      email: [
        '',
        [
          Validators.required,
          Validators.maxLength(32),
          Validators.pattern(this.emailRegex),
        ],
      ],
    });
  }
  getControl(name: any): AbstractControl | null {
    return this.forgotForm.get(name);
  }

  // forgotPassword() {
  //   console.log('Forgot password form submitted', this.forgotForm.value);

  //   const email = this.forgotForm.value.email;

  //   const url = `http://localhost:8082/forgot-password?email=${email}`;

  //   this.http.post<any>(url, {}).subscribe(data => {
  //     console.log('forgot ', data.status);
  //   }
  //     // (res) => {
  //     //   console.log("Email sent successfully", res);
  //     //   this.isEmailSent = true;
  //     //   this.isEmailFailed = false;
  //     // },
  //     // (err) => {
  //     //   console.log("Failed to send email", err);
  //     //   this.isEmailSent = false;
  //     //   this.isEmailFailed = true;
  //     // }
  //   );
  // }

  // Modify the forgotPassword method to handle the HTTP response
forgotPassword() {
  
  const email = this.forgotForm.value.email;
  
  const url = `http://localhost:8082/register/forgot-password?email=${email}`;

  
  console.log('Forgot password form submitted', this.forgotForm.value, url);

  this.http.post<any>(url, {}).subscribe(
    (res) => {
      // console.log("Response from server:", res);
      // if (res && res.status === 200) {
      //   // Check if the response is a valid JSON object
      //   console.log("Email sent successfully", Object.keys(res));
      //   this.isEmailSent = true;
      //   this.isEmailFailed = false;
      // } else {
      //   console.log("Invalid response from server:", res);
      //   // Handle the case where the response is not a valid JSON object
      //   this.isEmailSent = false;
      //   this.isEmailFailed = true;
      // }
    },
    (err) => {
      console.log("Failed to send email", err, err.status);
      this.isEmailSent = false;
      this.isEmailFailed = true;
      console.log("Response from server:", err);
      if (err && err.status === 200) {
        // Check if the response is a valid JSON object
        console.log("Email sent successfully", Object.keys(err));
        this.isEmailSent = true;
        this.isEmailFailed = false;
      } else {
        console.log("Invalid response from server:", err);
        // Handle the case where the response is not a valid JSON object
        this.isEmailSent = false;
        this.isEmailFailed = true;
      }
    }
  );
}



}
