import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-font-size',
  template: '<h2>Font size editor</h2>\n' +
    '\n' +
    '<div>\n' +
    '  <label>Enter font size (px):</label>\n' +
    '  <input type="number" [value]="fontSize" (change)="onChange($event.target.value)">\n' +
    '</div>\n' +
    '\n' +
    '<p class="output" [style.fontSize.px]="fontSize">\n' +
    '  Lorem ipsum dolor sit amet consectetur adipisicing elit. Eligendi cumque nostrum quibusdam. Inventore quibusdam debitis, tempore error voluptatem explicabo ipsum?\n' +
    '</p>'
})

export class FontSizeComponent implements OnInit {
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
