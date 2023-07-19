import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PropService } from '../services/prop.service';
import { Property } from '../property/property';
import { Agent } from '../agent/agent';
import { AgentService } from '../services/agent.service';
import { ScheduleService } from '../services/schedule.service';

@Component({
  selector: 'app-proprty-main',
  templateUrl: './proprty-main.component.html',
  styleUrls: ['./proprty-main.component.css']
})
export class ProprtyMainComponent implements OnInit {
  constructor(private route:ActivatedRoute,private propertyService:PropService ,private agentservices:AgentService, private sc:ScheduleService){}
  property_id:string |null ='';
  agent_Name:string | null ='';
  property:any;
  agent:any;
  ngOnInit(): void {
    this.route.paramMap.subscribe(params=>{
      this.property_id = params.get('id')??'';
      console.log("sending: "+this.property_id);
      this.sendData(this.property_id)
      this.propertyService.getPropertyById(this.property_id).subscribe(
        (response:any)=>{
          this.property = response;
          console.log(this.property);
          this.agentservices.getAgentByID(this.property.agentName).subscribe(
            (response:any)=>{
              console.log(response);
              this.agent = response;
            },(err:any)=>{
              console.log("error in agent "+err);
            }
          );
  
      },(err:any)=>{
        console.log(err);
      }
      );
    });
    

  }
  sendData(data:string) {
    this.sc.setData(data);
  }
  getImageSource(image: any): string {

    const imageType = image.type;

    const imageData = image.data;
    let imageFormat = 'jpeg';

    if (imageType === 1) {

      imageFormat = 'png';

    }




    return `data:image/${imageFormat};base64,${imageData}`;

  }



}
