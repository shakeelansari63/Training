import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Task } from '../../Task'
import { UiService } from '../../services/ui.service'
import { Subscription } from 'rxjs'

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  // Output for event emitter
  @Output() onTaskAdd: EventEmitter<Task> = new EventEmitter;

  // Forms class must contain property for each form input
  text: string;
  day: string;
  reminder: boolean = false;

  // Display form toggle
  displayForm: boolean;
  subscription: Subscription;

  constructor(private uiService: UiService) {
    this.subscription = this.uiService.onToggleTask().subscribe((value) => {
      this.displayForm = value;
    })
   }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.text == '' || this.day == '') {
      alert('Please enter Task detail')
    } else {
      // New Object
      const newTask = {
        text: this.text,
        day: this.day,
        reminder: this.reminder
      }

      // Lets emit this object
      this.onTaskAdd.emit(newTask);

      // Clear the form
      this.text = '';
      this.day = '';
      this.reminder = false;
    }
  }

}
