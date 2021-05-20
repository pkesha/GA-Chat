import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public userName: String;
  public password: String;
  public firstName: String;
  public lastName: String;

  constructor() { }

  ngOnInit(): void {
  }

  registerUser(): void {
    const newUser = {
      userName: this.userName,
      password: this.password,
      firstName: this.firstName,
      lastName: this.lastName
    };

  }

}
