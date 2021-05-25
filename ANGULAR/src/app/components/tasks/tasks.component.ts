import { Component, OnInit } from '@angular/core';

// Lets import Task model and Service for reading tasks
import { Task } from '../../Task'
import { TasksService } from '../../services/tasks.service'

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  // Initialise tasks to empty list. And we will populate it later
  tasks: Task[] = [];

  // In order to use Server, it need to be added to Constructor
  constructor(private taskService: TasksService) { }

  // Populate the tasks in onInit method because that runs on component initialization
  ngOnInit(): void {
    // If a method is returning Observable, we have to subscribe to observable
    // And Observable Subscription take function input which tells what to do if Observable push data.
    this.taskService.getTasks().subscribe((tasks) => {
      this.tasks = tasks;
    });
  }

  deleteTask(task_itm: Task) {
    this.taskService.deleteTask(task_itm).subscribe(() => {
      this.tasks = this.tasks.filter((t) => t.id !== task_itm.id)
    });
  }

}
