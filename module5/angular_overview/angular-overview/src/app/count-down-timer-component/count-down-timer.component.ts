import { Component, OnInit , OnDestroy , Input} from '@angular/core';

@Component({
  selector: 'app-count-down-timer-component',
  templateUrl: './count-down-timer.component.html',
  styleUrls: ['./count-down-timer.component.css']
})
export class CountDownTimerComponent implements OnInit,OnDestroy {
  private intervalId = 0;
  message = '';
  remainingTime: number;
  @Input()
  seconds = 11;
  constructor() { }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }

  clearTimer() {}
  start() {}
  stop() {}
  reset() {}
  private countDown() {}

}
