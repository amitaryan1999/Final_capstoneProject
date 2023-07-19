import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup, FormBuilder } from '@angular/forms';
import { ScheduleService } from '../services/schedule.service';


@Component({
  selector: 'app-schedule-tour',
  templateUrl: './schedule-tour.component.html',
  styleUrls: ['./schedule-tour.component.css']
})
export class ScheduleTourComponent implements OnInit {

  scheduleForm!: FormGroup 

  sdata = {
    cName: '',
    mobNo: '',
    date: '',
    slots: '',
    email: '',
    message: ''
  };

  minDate: string;

  constructor(
    private scheduleService: ScheduleService,
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
      email:['',Validators.required],
      property_id:['']
    });
  }

  onSubmit() {
    console.log("valid? ",this.scheduleForm.valid);
    console.log(this.scheduleForm.value.slots)
    if (this.scheduleForm.valid) {
      console.log('Form submitted');
      console.log('DATA', this.scheduleForm.value);
      const prop_id = this.scheduleService.getData().subscribe(data => {
        this.scheduleForm.value.property_id=data;
        console.log("data recvd ",data);
        this.scheduleService.addTourdata(this.scheduleForm.value).subscribe(
          (response: any) => {
            console.log(response);
          },
          (error: any) => {
            console.log(error);
          }
        );
      });


      
    } else {
      console.log('Form has validation errors');
    }
  }

}
