import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LibrariesService } from '../../../libraries/src/public-api';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'TestProj1';

  constructor(public lib: LibrariesService) {}
}
