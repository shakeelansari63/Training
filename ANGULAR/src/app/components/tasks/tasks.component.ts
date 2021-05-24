import { Component, OnInit } from '@angular/core';

// Lets import Task model and mock tasks
import { Task } from '../../Task'
import { TASKS } from '../../mock-tasks'

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  // Lets read all tasks from Mock tasks
  // Then these tasks can be used in tasks.componnets
  tasks: Task[] = TASKS;

  constructor() { }

  ngOnInit(): void {
  }

}
