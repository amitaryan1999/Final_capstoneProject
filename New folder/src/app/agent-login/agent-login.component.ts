import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AgentService } from '../services/agent.service';

@Component({
  selector: 'app-agent-login',
  templateUrl: './agent-login.component.html',
  styleUrls: ['./agent-login.component.css']
})
export class AgentLoginComponent {
  AgentForm:FormGroup;
  constructor(private fb:FormBuilder,private router: Router, private agentService:AgentService){
    this.AgentForm =  fb.group({
      username:['',Validators.compose([Validators.required])],
      password:['',Validators.compose([Validators.required])],
    });
  }
  redirectToLogin() {
    this.agentService.getAllAgents().subscribe(
      (response:any)=>{
        for(let data of response){
          
          if(this.AgentForm.value.username === data.agentEmail && this.AgentForm.value.password===data.agentPassoword){
            console.log(data.agentEmail);
          console.log(data.agentPassoword);
          window.location.href = `http://localhost:65457/?agentEmail=${data.agentEmail}`;

          }
        }
        
      }
      
    );
  }
}
