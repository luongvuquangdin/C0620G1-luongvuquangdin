import {Component, OnInit} from '@angular/core';
import {students} from './Students';
import {Student} from './Student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  students = students;
  student: Student;

  constructor() {
  }

  ngOnInit() {
  }

  infoStudent(student) {
    this.student = student;
  }

  changeParents(event: Student) {
    this.student = event;
  }
}
