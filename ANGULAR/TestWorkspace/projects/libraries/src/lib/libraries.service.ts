import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LibrariesService {

  constructor() { }

  sayHello() {
    return "Hello !!! from library service"
  }
}
