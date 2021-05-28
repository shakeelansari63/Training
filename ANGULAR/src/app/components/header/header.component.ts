import { Component, OnInit } from '@angular/core';
import { UiService} from '../../services/ui.service'
import { Subscription } from 'rxjs'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  title: string = 'Task Tracker';

  newTaskActive: boolean;
  subscription: Subscription;

  constructor(private uiService: UiService) {
    // Connect subscriotion to Observable
    this.subscription = this.uiService.onToggleTask().subscribe((value) => {
      this.newTaskActive = value;
    })
   }

  ngOnInit(): void {
  }

  toggleAddTask() {
    console.log("Add Task Button Clicked")

    // Call UI Service toggle to toggle options
    this.uiService.toggleNewTask()
  }
}
