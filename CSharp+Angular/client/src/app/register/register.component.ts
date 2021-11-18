import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Accounts } from '../_services/account.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  @Output() cancelForm: EventEmitter<boolean> = new EventEmitter();

  model: any = {};

  constructor(private acct: Accounts, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  registerUser() {
    this.acct.register(this.model).subscribe(result => {
      this.toastr.success("Registered Successfully");
      this.cancelAction();
    },
    error => {
      this.toastr.error(error.error);
    });
  }

  cancelAction() {
    this.cancelForm.emit(false);
  }
}
