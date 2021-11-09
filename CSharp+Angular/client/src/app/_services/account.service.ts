import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../_models/user.model';
import { map } from 'rxjs/operators';
import { ReplaySubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Accounts {

  private currentUser = new ReplaySubject<User>();
  currentUser$ = this.currentUser.asObservable();

  constructor(private http: HttpClient) { }

  baseUrl = "https://localhost:5001/api/";

  login(user: any) {
    return this.http.post(this.baseUrl + 'account/login', user).pipe(
      map((usr: User) => {
        localStorage.setItem('user', JSON.stringify(usr));
        this.currentUser.next(usr);
      })
    )
  }

  register(user: any) {
    return this.http.post(this.baseUrl + 'account/register', user).pipe(
      map((usr: User) => {
        localStorage.setItem('user', JSON.stringify(usr));
        this.currentUser.next(usr);
      })
    )
  }

  logout () {
    localStorage.removeItem('user');
    this.currentUser.next(null);
  }

  setCurrentUser(usr: User) {
    this.currentUser.next(usr);
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));
  }
}
