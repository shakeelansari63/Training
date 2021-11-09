import { Component, OnInit } from '@angular/core';
import { User } from '../_models/user.model';
import { Accounts } from '../_services/account.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {
  user: any = {};

  constructor(public acct: Accounts) { }

  ngOnInit(): void {
    this.acct.setCurrentUser(this.acct.getCurrentUser());
  }

  login() {
    this.acct.login(this.user).subscribe(usr => {
    })
  }

  logout() {
    this.acct.logout();
  }

}
