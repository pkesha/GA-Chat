import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public userName: string | undefined;
  public password: string | undefined;
  public token: any;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {

  }

  loginUser() {
    console.log("loginUser - component")
    const user = {
      userName: this.userName,
      password: this.password
    };
    console.log(localStorage);
    this.token = this.userService.loginUser(user);

  }


}
