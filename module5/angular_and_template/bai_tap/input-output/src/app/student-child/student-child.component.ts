import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Student} from '../Student';

@Component({
  selector: 'app-student-child',
  templateUrl: './student-child.component.html',
  styleUrls: ['./student-child.component.css']
})
export class StudentChildComponent implements OnInit {
  @Input()
  studentChile: Student;
  // tslint:disable-next-line:no-output-native
  @Output()
  changeEvent = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  changeInfo(age , mark) {
    this.studentChile.age = age.value;
    this.studentChile.mark = mark.value;
    this.changeEvent.emit(this.studentChile);
  }
}
