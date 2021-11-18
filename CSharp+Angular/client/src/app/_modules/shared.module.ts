import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { ToastrModule } from 'ngx-toastr';

let modules = [
  BsDropdownModule.forRoot(),
  ToastrModule.forRoot({positionClass: 'toast-bottom-right'})
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    modules
  ],
  exports: [modules]
})
export class SharedModule { }
