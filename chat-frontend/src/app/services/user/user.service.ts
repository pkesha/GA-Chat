import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {throwError} from "rxjs";

const url = 'http://localhost:9092';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
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
        localStorage.setItem('token', `${token}`);
      },
        () => {
        alert("Incorrect Login!");
        });
  }
}
