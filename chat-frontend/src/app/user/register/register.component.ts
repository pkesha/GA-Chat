import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user/user.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public userName: String | undefined;
  public password: String | undefined;
  public firstName: String | undefined;
  public lastName: String | undefined;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
  }

  registerUser(): void {
    const newUser = {
      userName: this.userName,
      password: this.password,
      firstName: this.firstName,
      lastName: this.lastName
    };

    this.userService.registerUser(newUser);
  }

}
