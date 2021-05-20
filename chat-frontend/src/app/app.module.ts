import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import {UserModule} from "./user/user.module";

@NgModule({
  declarations: [
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        UserModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
