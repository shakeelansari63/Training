import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Accounts } from '../_services/account.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  @Output() cancelForm: EventEmitter<boolean> = new EventEmitter();

  model: any = {};

  constructor(private acct: Accounts) { }

  ngOnInit(): void {
  }

  registerUser() {
    this.acct.register(this.model).toPromise();
    this.cancelAction();
  }

  cancelAction() {
    this.cancelForm.emit(false);
  }
}
