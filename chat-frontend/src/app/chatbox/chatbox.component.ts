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
      this.getChatMessages();

      if(!localStorage.getItem('currentUser')) {
        alert('<span> Need to login first! </span>');
      }
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
    let timeSent = new Date();
    timeSent.getDate();
    timeSent.getTime();
    timeSent.getHours();
    timeSent.getMinutes();
    timeSent.getSeconds();

    let newChatMessage: any = {
      message: this.message,
      date: timeSent
    };

    this.chatService.sendChatMessage(newChatMessage)
      .subscribe((response: any) => {
        console.log(response)
        this.getChatMessages();
      })
  }
}
