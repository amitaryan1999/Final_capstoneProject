import { Component } from '@angular/core';
import { PropService } from '../services/prop.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Property } from '../property/property';

@Component({
  selector: 'app-rent',
  templateUrl: './rent.component.html',
  styleUrls: ['./rent.component.css']
})
export class RentComponent {

  prop:Property;
  // Property prop=new Property();
  constructor(private propertyService:PropService,private router:Router,private route:ActivatedRoute ){
    this.prop=new Property();
  }
  property:Property[]=[];
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
