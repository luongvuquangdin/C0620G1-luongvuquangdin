import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  fontSize = 14;
  constructor() { }
  // tslint:disable-next-line:typedef
  onChange(value) {
    this.fontSize = value;
  }
  // tslint:disable-next-line:typedef
  ngOnInit() {
  }
}
