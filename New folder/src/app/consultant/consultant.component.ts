import { Component } from '@angular/core';
import { ConsultantService } from '../services/consultant.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-consultant',
  templateUrl: './consultant.component.html',
  styleUrls: ['./consultant.component.css']
})
export class ConsultantComponent {

  consultForm!: FormGroup 

  cdata = {
    fName: '',
    lName: '',
    email: '',
    message: ''
  };
  constructor(
    private consultService: ConsultantService,
    private formBuilder: FormBuilder
  ) {
    this.consultForm = this.formBuilder.group({
      fName: ['', Validators.required],
      lName: ['', Validators.required],
      email: ['', Validators.required],
      message: ['', Validators.required]
    });
  }

  ngOnInit() {
   
  }

  onSubmit() {
    console.log("valid? ",this.consultForm.valid);
    console.log(this.consultForm.value.slots)
    if (this.consultForm.valid) {
      console.log('Form submitted');
      console.log('DATA', this.consultForm.value);

      this.consultService.addTourdata(this.consultForm.value).subscribe(
        (response: any) => {
          console.log(response);
        },
        (error: any) => {
          console.log(error);
        }
      );
    } else {
      // Handle form validation errors
      console.log('Form has validation errors');
      // You can display an error message or perform any other actions here
    }
  }

}
