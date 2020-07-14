import { Component, OnInit } from '@angular/core';
import { User } from 'app/models/User';
import { AuthService } from 'app/services/auth.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.sass']
})
export class LoginPageComponent implements OnInit {

  currentDate = new Date();
  user: User;
  constructor(private authService: AuthService, private router: Router) { 
    this.user = new User();
  }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.user);
    this.authService.login(this.user.email, this.user.password).subscribe(result => {
      console.log(result);
      this.authService.setSession(result);
      this.router.navigate(['/admin/home'])
    }, err => {
      console.log(err)
      Swal.fire({
        title: "Erro :(",
        text: err.error.message,
        type: 'error'
      })
    })
  }

}
