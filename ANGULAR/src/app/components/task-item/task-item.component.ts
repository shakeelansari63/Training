import { Component, OnInit, Input } from '@angular/core';

// Import Task model
import { Task } from '../../Task'

// Import FontAwesome Times Icon whic is X
import { faTimes } from '@fortawesome/free-solid-svg-icons'

@Component({
  selector: 'app-task-item',
  templateUrl: './task-item.component.html',
  styleUrls: ['./task-item.component.css']
})
export class TaskItemComponent implements OnInit {

  //Define Task Property
  @Input() task_itm: Task;

  // Set the Icon property and now this property can be used in html
  faTimes = faTimes;

  constructor() { }

  ngOnInit(): void {
  }

}
