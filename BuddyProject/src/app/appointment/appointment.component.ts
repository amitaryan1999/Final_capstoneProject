import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AppointService } from '../Services/appoint.service';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  
  scheduleForm!: FormGroup 

  sdata = {
    cName: '',
    mobNo: '',
    date: '',
    slots: '',
    email: '',
    message: '',
    department :'',
    doctor : ''
  };

  minDate: string;

  constructor(
    private appointService: AppointService,
    private formBuilder: FormBuilder
  ) {
    

    const currentDate = new Date();
    currentDate.setDate(currentDate.getDate() + 1);
    this.minDate = currentDate.toISOString().split('T')[0];
  }

  ngOnInit() {
    this.scheduleForm = this.formBuilder.group({
      cName: ['', Validators.required],
      mobNo: ['', [Validators.required, Validators.pattern('[0-9]+'), Validators.maxLength(10)]],
      date: ['', Validators.required],
      slots: ['', Validators.required],
      department: ['', Validators.required],
      doctor : ['', Validators.required]
    });
  }

  onSubmit(scheduleForm:FormGroup) {
    console.log("valid? ",scheduleForm.valid);
    console.log(scheduleForm.value.slots)
    if (scheduleForm.valid) {
      console.log('Form submitted');
      console.log('DATA', scheduleForm.value);
    
      this.appointService.addAppointdata(scheduleForm.value).subscribe(
        (response: any) => {
          console.log(response);
        },
        (error: any) => {
          console.log(error);
        }
      );
    } else {
      console.log('Form has validation errors');
    }
  }


}
