import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent {
  title = 'client';
  authService: AuthService;
  constructor(private auth: AuthService) {}

  ngOnInit() {
    this.authService = this.auth;
    console.log(this.authService.isLogged())
  }

}
