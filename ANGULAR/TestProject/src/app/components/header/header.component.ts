import { Component, OnInit } from '@angular/core';
import { UiService} from '../../services/ui.service'
import { Subscription } from 'rxjs'
import { Router } from '@angular/router'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  title: string = 'Task Tracker';

  newTaskActive: boolean;
  subscription: Subscription;

  constructor(private uiService: UiService, private router: Router) {
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

  // return true is input route is matching the current route. 
  // This will help us to hide button on any other route except index '/' route
  routeMatch(route: string) {
    return this.router.url === route;
  }
}
