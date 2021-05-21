import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from "./user/register/register.component";
import {LoginComponent} from "./user/login/login.component";
import {ChatboxComponent} from "./chatbox/chatbox.component";
import {LogoutComponent} from "./user/logout/logout.component";
import {ChatmessageComponent} from "./chatmessage/chatmessage.component";

const routes: Routes = [
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'logout',
    component: LogoutComponent
  },
  {
    path: 'chatbox',
    component: ChatboxComponent,
    children: [
      {
        path: 'chatmessage/:id',
        component: ChatmessageComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
