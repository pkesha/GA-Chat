import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {UserModule} from "./user/user.module";
import {HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";
import { ChatMessagesComponent } from './chat-messages/chat-messages.component';

@NgModule({
  declarations: [
    AppComponent,
    ChatMessagesComponent
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
