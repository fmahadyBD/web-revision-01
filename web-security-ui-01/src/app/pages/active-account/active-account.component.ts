import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AuthenticationService } from '../../services/services';

@Component({
  selector: 'app-active-account',
  standalone: false,
  templateUrl: './active-account.component.html',
  styleUrl: './active-account.component.scss'
})
export class ActiveAccountComponent {

  message = "";
  isOkay = true;
  submitted = false;

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) { }

  private confirmAccount(token: string) {
    this.authService.confirm({ token }).subscribe({
      next: () => {
        this.message = 'Your account has been successfully activated.\nNow you can proceed to login';
        this.submitted = true;
      },
      error: () => {
        this.message = 'Token has been expired or invalid';
        this.submitted = true;
        this.isOkay = false;
      }
    });
  }

  redirectedToLofin() {
    this.router.navigate(['login']);
  }
  onCodeCompleted(event: any) {
    const token = event;
    this.confirmAccount(token);
  }
}
