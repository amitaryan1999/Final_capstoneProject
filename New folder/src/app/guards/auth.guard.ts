// import { Injectable } from '@angular/core';

// import { CanActivate, Router } from '@angular/router';

// import { MatSnackBar } from '@angular/material/snack-bar';

// import { AuthService } from '../services/auth.service';




// @Injectable({

//   providedIn: 'root'

// })

// export class AuthGuard implements CanActivate {




//   constructor(private authService: AuthService, private router: Router, private snackBar: MatSnackBar) {}




  // canActivate(): boolean {

  //   if (this.authService.isAuthenticated()) {

  //     return true;

  //   } else {

  //     this.snackBar.open('Please login to continue.', 'Close', { duration: 3000 });

  //     this.router.navigate(['/login']); // Adjust the route to your login page

  //     return false;

  //   }

//   }

// }