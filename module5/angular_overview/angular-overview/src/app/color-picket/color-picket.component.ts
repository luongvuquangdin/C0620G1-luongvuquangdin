import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picket',
  templateUrl: './color-picket.component.html',
  styleUrls: ['./color-picket.component.css']
})
export class ColorPicketComponent implements OnInit {
  color = "#00e067";


  constructor() { }

  ngOnInit(): void {
  }

  changeColor(value){
    this.color=value;
  }

}
