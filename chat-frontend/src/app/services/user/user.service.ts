import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subject, throwError} from "rxjs";
import {Router} from "@angular/router";

const url = 'http://localhost:9092';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  currentUser: string | undefined;
  searchSubject = new Subject();

  constructor(private http: HttpClient, private router: Router) {
  }

  registerUser(user: any): void {
    this.http
      .post(`${url}/auth/users/register`, user)
      .subscribe(user => {
        console.log(user);
        alert("Registration Successful!");
      },
        () => {
          alert("Invalid Registration!");
        });
  }

  loginUser(user: any): any {
    this.http
      .post(`${url}/auth/users/login`, user)
      .subscribe(response => {
        // @ts-ignore
        let token = response['jwt'];
        localStorage.setItem('currentUser', `${user.userName}`);
        localStorage.setItem('token', `${token}`);
        this.currentUser = user.userName;
        this.router.navigate(['/chatbox']);
      },
        () => {
        alert("Incorrect Login!");
        });
  }

  logoutUser(): void {
    localStorage.removeItem('currentUser');
  }
}
