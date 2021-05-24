import { Injectable } from '@angular/core';

// We will use Servcie to Interact with Model and refrain from using UI elements doind that
import { Task } from '../Task'
import { TASKS } from '../mock-tasks'
import { Observable, of} from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class TasksService {

  constructor() { }

  // And lets have a method to get all tasks

  // Observables are list of items pushed from Service. And In order to use the Observables, we have to make some changes.
  // If reading from static file, its easy to set data as file. But we have to keep polling file for changes
  // And load it again. But Observables make it server push and if data change, it pushes to server
  getTasks(): Observable<Task[]> {
    // Convert list to Observable using 'of'
    const tasks = of(TASKS);

    // Return Observable
    return tasks;
  }
}
