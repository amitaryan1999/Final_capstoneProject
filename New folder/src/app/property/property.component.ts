
import { Component, OnInit } from '@angular/core';
import { PropService } from '../services/prop.service';
import { Property } from './property';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-property',
  templateUrl: './property.component.html',
  styleUrls: ['./property.component.css']
})
export class PropertyComponent implements OnInit{
  prop:any;
  // Property prop=new Property();
  constructor(private propertyService:PropService,private router:Router,private route:ActivatedRoute ){
  }
  property:any[]=[];
  ngOnInit(): void {
    this.propertyService.getAllProperties().subscribe(
      (response:any)=>{
      this.property = response;
        console.log(this.property);
      },

      err=>{
        console.log("Error Occurred!! "+err);
      }

    );
  }
  navigateToPropertyMain(property_id:string):void{
    this.router.navigate(['/proprty-main',property_id]);
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
