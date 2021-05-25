import { Injectable } from '@angular/core';

// We will use Servcie to Interact with Model and refrain from using UI elements doind that
import { Task } from '../Task'
//import { TASKS } from '../mock-tasks'
// Lets Connect to HTTP JSOn Server
import { HttpClient, HttpHeaders} from '@angular/common/http'
import { Observable} from 'rxjs'
import { TmplAstElement } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class TasksService {
  // Api URL
  private apiURL = 'http://localhost:5000/tasks'

  // And we have to add http client in constructor to us it
  constructor(private httpCl: HttpClient) { }

  // And lets have a method to get all tasks

  // Observables are list of items pushed from Service. And In order to use the Observables, we have to make some changes.
  // If reading from static file, its easy to set data as file. But we have to keep polling file for changes
  // And load it again. But Observables make it server push and if data change, it pushes to server
  getTasks(): Observable<Task[]> {
    // Convert list to Observable using 'of'
    // const tasks = of(TASKS);

    // Now we have made and API using JSON-SERVER and it is serving the Task data on localhost:5000, we can use that json server
    // instead of mock Data file and any changes we do on JSON-Server will reflect on our app

    // Return Observable
    return this.httpCl.get<Task[]>(this.apiURL);
  }

  // Method to delete Task
  deleteTask(task: Task): Observable<Task> {
    // generate URL with Task ID
    const delUrl = `${this.apiURL}/${task.id}`;

    // Call Delete method to delete the Item and return 1 task 
    return this.httpCl.delete<Task>(delUrl);
  }
}
