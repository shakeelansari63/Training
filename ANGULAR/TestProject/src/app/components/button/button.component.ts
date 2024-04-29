import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {
  // Input tells to take input options while embedding ui components
  // Following options can be passed in app-button tag as <app-button text='XYZ' color=''></app-button>
  @Input() text: string|undefined; 
  @Input() color: string|undefined;

  // Output event emiter will send the button click event out
  @Output() btnClick = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }

  onClick() {
    // When Button is clicked, we can do something
    console.log(this.text + ' button clicked!!!');

    // And lets emit the event so outer classes can catch and action
    this.btnClick.emit();

  }
}
