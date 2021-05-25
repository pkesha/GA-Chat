import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ChatboxComponent} from "./chatbox/chatbox.component";
import {ChatmessageComponent} from "./chatmessage/chatmessage.component";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    ChatboxComponent,
    ChatmessageComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    ChatboxComponent,
    ChatmessageComponent
  ]
})
export class ChatModule {
}
