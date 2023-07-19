import { Component, OnInit } from '@angular/core';
import { AgentService } from '../services/agent.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Agent } from './agent';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.css']
})
export class AgentComponent implements OnInit{

  
  constructor(private agentservices:AgentService,private router:Router,private route:ActivatedRoute ){

  }
  agentData:any[]=[];

  ngOnInit(): void {
    this.agentservices.getAllAgents().subscribe(
      (response:any)=>{
        console.log(response);
        this.agentData = response;
      console.log(this.agentData[0].agentName);
      },
      err=>{
        console.log("Error Occurred!! "+err);
      }

  );


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
