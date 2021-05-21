import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {UserModule} from "./user/user.module";
// import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import { ChatboxComponent } from './chatbox/chatbox.component';
import { ChatmessagesComponent } from './chatmessages/chatmessages.component';
import { LogoutComponent } from './logout/logout.component';
// import {InterceptorService} from "./services/error/interceptor.service";

@NgModule({
  declarations: [
    AppComponent,
    ChatboxComponent,
    ChatmessagesComponent,
    LogoutComponent
  ],
    imports: [
      HttpClientModule,
      BrowserModule,
      CommonModule,
      AppRoutingModule,
      FormsModule,
      UserModule
    ],
  providers: [
    // {
    //   provide: HTTP_INTERCEPTORS,
    //   useClass: InterceptorService,
    //   multi: true
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
