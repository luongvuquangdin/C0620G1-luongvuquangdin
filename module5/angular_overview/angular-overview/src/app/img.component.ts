import {Component} from '@angular/core';

@Component({
  selector:'app-img-pet',
  templateUrl: './img-pet.component.html'
})

export class PetComponent {
  petName = 'puppie';
  petImage = 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';
  constructor() { }

  // tslint:disable-next-line:typedef
  updateName(name) {
    this.petName = name;
  }

  // tslint:disable-next-line:typedef
  updateImage(image) {
    this.petImage = image;
  }

}
