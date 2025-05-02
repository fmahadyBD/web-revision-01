import { Component } from '@angular/core';
import { RegisterRequest } from '../../services/models';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/services';

@Component({
  selector: 'app-register',
  standalone: false,
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  registerRequest: RegisterRequest = { email: '', name: '', passowrd: '' };
  errorMesg: Array<string> = [];

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) { }


  login() {
    this.router.navigate(['login']);
  }

  register() {
    this.errorMesg = [];
    this.authService.register({
      body: this.registerRequest
    }).subscribe({
      next: () => {
        this.router.navigate(['active-account']);
      },
      error: (err) => {
        this.errorMesg = err.error.validationErrors;
      }
    });
  }
}
