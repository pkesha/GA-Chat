import { Component, OnInit } from '@angular/core';
import {ChatService} from "../services/chat/chat.service";

@Component({
  selector: 'app-chatbox',
  templateUrl: './chatbox.component.html',
  styleUrls: ['./chatbox.component.css']
})
export class ChatboxComponent implements OnInit {
  // @ts-ignore
  public chatMessages: [];
  public message: string | undefined;

  constructor(private chatService : ChatService) { }

  ngOnInit(): void {
    if(this.chatMessages === null) {

    } else {

    }
  }

  getChatMessages(): void {
    this.chatService.getMessages()
      .subscribe(messages => {
        // @ts-ignore
        this.chatMessages = messages;
        console.log(this.chatMessages);
      });
  }

  sendMessage(): any {
    let newChatMessage: any = {
      message: this.message,
      date: Date.now()
    };

    this.chatService.sendChatMessage(newChatMessage)
      .subscribe((response: any) => {
        console.log(response)
        this.getChatMessages();
      })
  }
}
