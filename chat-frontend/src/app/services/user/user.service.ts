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
    console.log('user service - registerUser method');
    this.http
      .post(`${url}/auth/users/register`, user)
      .subscribe(user => {
        console.log(user);
      });
  }

  loginUser(user: any): any {
    this.http
      .post(`${url}/auth/users/login`, user)
      .subscribe(response => {
        // @ts-ignore
        let token = response['jwt'];
        console.log(response);
        localStorage.setItem('token', `${token}`);
      },
        (error) => {
        localStorage.setItem('login_error', 'true');
        alert("Incorrect Login!")
        });
  }
}
