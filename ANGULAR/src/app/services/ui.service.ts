import { Injectable } from '@angular/core';
import { Observable, Subject} from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class UiService {

  private newTaskActive: boolean = false;
  private subject = new Subject<any>();

  constructor() { }

  toggleNewTask() {
    this.newTaskActive = !this.newTaskActive;
    this.subject.next(this.newTaskActive)
  }

  onToggleTask() {
    return this.subject.asObservable();
  }

}
