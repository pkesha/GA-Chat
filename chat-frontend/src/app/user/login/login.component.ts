import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user/user.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public userName: string | undefined;
  public password: string | undefined;
  public token: any;
  public errorLogin: boolean = false;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  loginUser() {
    const user = {
      userName: this.userName,
      password: this.password
    };
    //console.log(localStorage.getItem("token"));
    this.token = this.userService.loginUser(user)
      .subscribe((content: string) => {
        console.log("login component " + content)
      //Load chat component
    },
      (error: HttpErrorResponse) => {
        console.log("error from login component " + error);
          //this.errorLogin = true;
          console.log(this.errorLogin);
      });
  }


}
