import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {UserModule} from "./user/user.module";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import { ChatboxComponent } from './chatbox/chatbox.component';
import { ChatmessageComponent } from './chatmessage/chatmessage.component';

@NgModule({
  declarations: [
    AppComponent,
    ChatboxComponent,
    ChatmessageComponent
  ],
    imports: [
      HttpClientModule,
      BrowserModule,
      CommonModule,
      AppRoutingModule,
      FormsModule,
      UserModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
