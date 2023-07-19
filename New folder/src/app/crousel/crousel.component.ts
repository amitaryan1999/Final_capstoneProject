import { Component, OnInit } from '@angular/core';
import { CrouselService } from '../services/crousel.service';
import { PropService } from '../services/prop.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Property } from '../property/property';
import { Crousel } from './Crousel';

@Component({
  selector: 'app-crousel',
  templateUrl: './crousel.component.html',
  styleUrls: ['./crousel.component.css']
})
export class CrouselComponent implements OnInit {


  constructor(private propertyService:PropService,private crouselservices:CrouselService,private router:Router,private route:ActivatedRoute ){

  }
  crousel:Crousel[]=[];
  propertyC:any[]=[];

  ngOnInit(): void {
    this.crouselservices.getPropertyID().subscribe(
      (response:any)=>{
      this.crousel = response;

       for(let i of this.crousel){
        console.log("Property ID"+ i.propertyID);
        this.propertyService.getPropertyById(i.propertyID).subscribe(
          (response:any)=>{
            this.propertyC.push(response);
          },
          err=>{
            console.log("Error Occurred!! "+err);
          });
       }
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
