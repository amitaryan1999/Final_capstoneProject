import { Component } from '@angular/core';
import { AppointService } from '../Services/appoint.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent{
 
  constructor( private appointservices:AppointService){}
Appoint:any[]=[];
ngOnInit(): void{
  this.appointservices.getAllAppoint().subscribe((Response:any)=>{ 
    this.Appoint=Response})
}


}

