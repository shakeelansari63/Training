import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

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
  @Output() onDeleteTask = new EventEmitter();

  // Set the Icon property and now this property can be used in html
  faTimes = faTimes;

  constructor() { }

  ngOnInit(): void {
  }

  deleteTask() {
    this.onDeleteTask.emit(this.task_itm);
    // Log 
    console.log("Deleting Task: " + this.task_itm.id);
  }

}
