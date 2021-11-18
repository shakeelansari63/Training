import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from '../_models/user.model';
import { Accounts } from '../_services/account.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {
  user: any = {};

  constructor(public acct: Accounts, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.acct.setCurrentUser(this.acct.getCurrentUser());
  }

  login() {
    this.acct.login(this.user).subscribe(usr => {
      this.router.navigateByUrl("/members");
    },
    error => {
      this.toastr.error(error.error);
    })
  }

  logout() {
    this.acct.logout();
    this.router.navigateByUrl("/");
  }

}
