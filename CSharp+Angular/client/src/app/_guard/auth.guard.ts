import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Accounts } from '../_services/account.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(
    private acct: Accounts,
    private toastr: ToastrService
  ){}
  canActivate(): Observable<boolean | UrlTree> {
    return this.acct.currentUser$.pipe(
      map(usr => {
        if (usr) return true;

        this.toastr.error("Please login !!")
        return false;
      })
    );
  }
  
}
