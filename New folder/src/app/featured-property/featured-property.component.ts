
import { Component, OnInit } from '@angular/core';
import { Featured } from './featured';
import { FeaturedPService } from '../services/featured-p.service';
import { PropService } from '../services/prop.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Property } from '../property/property';

@Component({
  selector: 'app-featured-property',
  templateUrl: './featured-property.component.html',
  styleUrls: ['./featured-property.component.css']
})
export class FeaturedPropertyComponent implements OnInit {


  constructor(private propertyService:PropService,private featuredservices:FeaturedPService,private router:Router,private route:ActivatedRoute ){

  }
  featured:Featured[]=[];
  propertyF:any[]=[];

  ngOnInit(): void {
    this.featuredservices.getAllFeaturedProperty().subscribe(
      (response:any)=>{
      this.featured = response;
  

       for(let i of this.featured){
        this.propertyService.getPropertyById(i.property_Id).subscribe(
          (response:any)=>{
            this.propertyF.push(response);
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